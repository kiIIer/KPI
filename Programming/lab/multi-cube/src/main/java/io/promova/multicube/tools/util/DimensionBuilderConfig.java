package io.promova.multicube.tools.util;

import io.promova.multicube.calculators.IFormula;
import io.promova.multicube.models.Dimension;
import io.promova.multicube.models.Parameter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class DimensionBuilderConfig
{
    public int dimension;
    public List<Parameter> parameters;
    public Dimension myDimension;
    public ExecutorService executorService;
    public Semaphore semaphore;
    public Map<String, Integer> coefficientMap;
    public IFormula formula;

    public DimensionBuilderConfig(
            int dimension,
            List<Parameter> parameters,
            Dimension myDimension,
            ExecutorService executorService,
            Semaphore semaphore,
            Map<String, Integer> coefficientMap,
            IFormula formula)
    {
        this.dimension = dimension;
        this.parameters = parameters;
        this.myDimension = myDimension;
        this.executorService = executorService;
        this.semaphore = semaphore;
        this.coefficientMap = coefficientMap;
        this.formula = formula;
    }
}
