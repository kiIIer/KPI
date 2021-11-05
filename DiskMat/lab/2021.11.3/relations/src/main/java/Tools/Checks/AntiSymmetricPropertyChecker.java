package Tools.Checks;

public class AntiSymmetricPropertyChecker implements IAntiSymmetricPropertyChecker
{
    @Override
    public boolean check(int[][] matrix)
    {
        int length = matrix.length;

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (i == j)
                {
                    continue;
                }
                if (matrix[i][j] == matrix[j][i] && matrix[i][j] == 1)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
