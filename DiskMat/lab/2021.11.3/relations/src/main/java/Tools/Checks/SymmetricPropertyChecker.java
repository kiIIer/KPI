package Tools.Checks;

public class SymmetricPropertyChecker implements ISymmetricPropertyChecker
{
    @Override
    public boolean check(int[][] matrix)
    {
        int length = matrix.length;
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (matrix[i][j] != matrix[j][i])
                {
                    return false;
                }
            }
        }

        return true;
    }
}
