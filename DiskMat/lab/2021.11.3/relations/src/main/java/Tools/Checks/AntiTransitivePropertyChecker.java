package Tools.Checks;

public class AntiTransitivePropertyChecker implements IAntiTransitivePropertyChecker
{
    @Override
    public boolean check(int[][] matrix)
    {
        int length = matrix.length;
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (matrix[i][j] == 1)
                {
                    for (int k = 0; k < length; k++)
                    {
                        if (matrix[j][k] == 1 && matrix[i][k] == 1)
                        {
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }
}
