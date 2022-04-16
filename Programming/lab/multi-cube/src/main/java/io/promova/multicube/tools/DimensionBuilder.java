package io.promova.multicube.tools;

import io.promova.multicube.models.Dimension;
import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.util.DimensionBuilderConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class DimensionBuilder implements Runnable
{
    private final DimensionBuilderConfig config;

    public DimensionBuilder(DimensionBuilderConfig config)
    {
        this.config = config;
    }

    @Override
    public void run()
    {
        int paramsNum = config.parameters.size();
        if (paramsNum == config.dimension)
        {
            Map<String, Double> paramValues = new HashMap<>();
            config.parameters.stream().forEach(parameter -> paramValues.put(
                    parameter.getName(),
                    parameter.getValue(
                            config.coefficientMap
                                    .get(parameter.getName())
                    )
            ));
            config.myDimension.setValue(config.formula.compute(paramValues));
            config.semaphore.release();
            return;
        }
        Parameter myParam = config.parameters.get(config.dimension);
        config.myDimension.setParameterName(myParam.getName());
        int myIterations = myParam.getIterations();
        Map<Double, Dimension> dimensions = new ConcurrentHashMap<>();

        for (int i = 0; i < myIterations; i++)
        {
            Dimension subDimension = new Dimension();
            Map<String, Integer> subCoefficientMap = new ConcurrentHashMap<>(config.coefficientMap);
            subCoefficientMap.put(myParam.getName(), i);
            try
            {
                config.semaphore.acquire();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            DimensionBuilder builder = new DimensionBuilder(new DimensionBuilderConfig(
                    config.dimension + 1,
                    config.parameters,
                    subDimension,
                    config.executorService,
                    config.semaphore,
                    subCoefficientMap,
                    config.formula
            ));
            dimensions.put(myParam.getValue(i), subDimension);
            config.executorService.execute(builder);

        }
        config.myDimension.setDimensions(dimensions);
        config.semaphore.release();

    }
}
