package io.promova.tablemath.endpoints.tools;

import io.promova.tablemath.models.Parameter;

import java.util.List;

public class RowFormer implements Runnable
{
    private final long staticParamA;
    private final Parameter paramB;
    private final List<Long> resultSheet;
    private final IFormulaSolver formulaSolver;

    public RowFormer(long staticParamA, Parameter paramB, List<Long> resultSheet, IFormulaSolver formulaSolver)
    {
        this.staticParamA = staticParamA;
        this.paramB = paramB;
        this.resultSheet = resultSheet;
        this.formulaSolver = formulaSolver;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < paramB.getIterations(); i++)
        {
            resultSheet.set(i, formulaSolver.solve(staticParamA, paramB.getValue(i)));
        }
        Thread.yield();
    }
}
