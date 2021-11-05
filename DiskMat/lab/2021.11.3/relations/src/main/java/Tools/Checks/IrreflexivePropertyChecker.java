package Tools.Checks;

public class IrreflexivePropertyChecker implements IIrreflexivePropertyChecker
{
    @Override
    public boolean check(int[][] matrix)
    {
        int length = matrix.length;

        for (int i = 0; i < length; i++)
        {
            if (matrix[i][i] != 0)
            {
                return false;
            }
        }

        return true;
    }
}
