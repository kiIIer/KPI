package Definer;

public class GraphDefiner implements IGraphDefiner
{
    @Override
    public boolean defineOriented(int[][] graphMatrix)
    {
        var length = graphMatrix.length;

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (i == j)
                {
                    continue;
                }
                if (graphMatrix[i][j] != graphMatrix[j][i])
                {
                    return true;
                }
            }

        }

        return false;
    }
}
