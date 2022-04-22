package io.promova.multicube.endpoints;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.promova.multicube.calculators.ITranslator;
import io.promova.multicube.models.Dimension;
import io.promova.multicube.models.HypercubeRequest;
import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.DimensionBuilder;
import io.promova.multicube.tools.IDimensionBuilderFactory;
import io.promova.multicube.tools.Terminator;
import io.promova.multicube.tools.util.DimensionBuilderConfig;
import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;

@RestController
public class CubeController
{
    private final ITranslator translator;
    private final IDimensionBuilderFactory dimensionBuilderFactory;

    public CubeController(
            ITranslator translator,
            IDimensionBuilderFactory dimensionBuilderFactory
    )
    {
        this.translator = translator;
        this.dimensionBuilderFactory = dimensionBuilderFactory;
    }

    @PostMapping("/hypercube")
    public Dimension one(
            @RequestBody HypercubeRequest request
    )
    {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Semaphore semaphore = new Semaphore(Integer.MAX_VALUE);
        try
        {
            semaphore.acquire();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        executorService.execute(new Terminator(semaphore, executorService));

        Dimension topLvl = new Dimension();
        DimensionBuilder builder = dimensionBuilderFactory.create(new DimensionBuilderConfig(
                0,
                request.getParameters(),
                topLvl,
                executorService,
                semaphore,
                new ConcurrentHashMap<>(),
                this.translator.translate(request.getPolish())
        ));
        executorService.execute(builder);
        try
        {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return topLvl;
    }
}
