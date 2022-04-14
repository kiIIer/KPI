package io.promova.tablemath.endpoints.tools;

import io.promova.tablemath.models.Matrix;
import io.promova.tablemath.models.Parameter;

import java.time.Year;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MatrixFormer implements IMatrixFormer
{
    private final IFormulaSolver formulaSolver;

    public MatrixFormer(IFormulaSolver formulaSolver)
    {
        this.formulaSolver = formulaSolver;
    }

    @Override
    public void form(Matrix matrix, Parameter paramA, Parameter paramB)
    {
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        int index = 0;
        for (long i = paramA.getLowerBound(); i < paramA.getUpperBound(); i += paramA.getStep(), index++)
        {
            RowFormer rowFormer = new RowFormer(i, paramB, matrix.getRow(index), formulaSolver);
            ex.execute(rowFormer);
        }
        ex.shutdown();

        try
        {
            ex.awaitTermination(0, TimeUnit.DAYS);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
