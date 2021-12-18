package Validators;

public class GraphValidator implements IGraphValidator
{
    @Override
    public boolean isValid(int[][] graphMatrix)
    {
        if (!isNotNull(graphMatrix))
        {
            return false;
        }

        if (!isSquare(graphMatrix))
        {
            return false;
        }
        return isBoolean(graphMatrix);
    }

    private boolean isNotNull(int[][] matrix)
    {
        if (matrix == null)
        {
            return false;
        }

        for (int[] row : matrix)
        {
            if (row == null)
            {
                return false;
            }
        }

        return true;
    }

    private boolean isSquare(int[][] matrix)
    {
        var length = matrix.length;
        for (int[] row : matrix)
        {
            if (row.length != length)
            {
                return false;
            }

        }
        return true;
    }

    private boolean isBoolean(int[][] matrix)
    {
        for (int[] row : matrix)
        {
            for (int element : row)
            {
                if (element != 0 && element != 1)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
