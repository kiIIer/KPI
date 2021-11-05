package Tools.Checks;

public class ReflexivePropertyChecker implements IReflexivePropertyChecker
{
    @Override
    public boolean check(int[][] matrix)
    {
        int length = matrix.length;
        for (int i = 0; i < length; i++)
        {
            if (matrix[i][i] != 1)
            {
                return false;
            }
        }

        return true;
    }
}
