package io.promova.tablemath.endpoints.tools;

import io.promova.tablemath.models.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixFormer implements IMatrixFormer
{
    private final IFormulaSolver formulaSolver;
    private List<List<Long>> matrix;

    public MatrixFormer(IFormulaSolver formulaSolver)
    {
        this.formulaSolver = formulaSolver;
    }

    @Override
    public List<List<Long>> form(Parameter paramA, Parameter paramB)
    {
        createMatrix(paramA.getIterations(), paramB.getIterations());

        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < paramA.getIterations(); i++)
        {
            RowFormer rowFormer = new RowFormer(paramA.getValue(i), paramB, matrix.get(i), formulaSolver);
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

        return matrix;
    }

    private void createMatrix(int rows, int columns)
    {
        matrix = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++)
        {
            matrix.add(createRow(columns));
        }

    }

    private List<Long> createRow(int columns)
    {
        List<Long> row = new ArrayList<>(columns);
        for (int i = 0; i < columns; i++)
        {
            row.add(0L);
        }

        return row;
    }
}
