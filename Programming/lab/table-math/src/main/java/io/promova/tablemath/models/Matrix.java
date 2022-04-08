package io.promova.tablemath.models;

import java.util.List;

public class Matrix
{
    private List<List<Long>> miniMatrix;

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
}
