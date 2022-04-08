package io.promova.tablemath.models;

import java.util.ArrayList;
import java.util.List;

public class Matrix
{
    private List<List<Long>> miniMatrix;

    public Matrix(int maxX, int maxY)
    {
        miniMatrix = new ArrayList<>(maxY);
        for (int i = 0; i < maxY; i++)
        {
            List<Long> row = new ArrayList<>(maxX);
            for (int j = 0; j < maxX; j++)
            {
                row.add(0L);
            }
            miniMatrix.add(row);
        }
    }

    public long get(int x, int y)
    {
        return miniMatrix.get(y).get(x);
    }

    public boolean set(int x, int y, long value)
    {
        List<Long> row = miniMatrix.get(y);
        row.set(x, value);
        miniMatrix.set(y, row);

        return true;
    }

    public List<Long> getRow(int y)
    {
        return miniMatrix.get(y);
    }

    public List<List<Long>> getMiniMatrix()
    {
        return miniMatrix;
    }
}
