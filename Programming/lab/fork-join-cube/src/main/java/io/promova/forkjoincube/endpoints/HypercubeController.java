package io.promova.forkjoincube.endpoints;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.models.request.HypercubeRequest;
import io.promova.forkjoincube.porcessors.cube.IRecursiveFormerFactory;
import io.promova.forkjoincube.porcessors.cube.RecursiveFormer;
import io.promova.forkjoincube.porcessors.job.IJobCreator;
import io.promova.forkjoincube.porcessors.polish.ITranslator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

@RestController
public class HypercubeController
{
    private final ITranslator translator;
    private final IJobCreator jobCreator;
    private final IRecursiveFormerFactory recursiveFormerFactory;

    public HypercubeController(ITranslator translator, IJobCreator jobCreator, IRecursiveFormerFactory recursiveFormerFactory)
    {
        this.translator = translator;
        this.jobCreator = jobCreator;
        this.recursiveFormerFactory = recursiveFormerFactory;
    }

    @PostMapping("/hypercube")
    public void create(
            @RequestBody HypercubeRequest request
    )
    {
        Formula formula = translator.translate(request.polish());
        List<CalculateJob> jobs = jobCreator.create(request.parameters(), formula);
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        RecursiveFormer recursiveFormer = recursiveFormerFactory.create(jobs);
        Object result = commonPool.invoke(recursiveFormer);

    }
}
