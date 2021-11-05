package Tools;

public class MatrixUnioner implements IMatrixUnioner
{
    @Override
    public int[][] calculate(int[][] matrix1, int[][] matrix2)
    {
        int length = matrix1.length;

        int[][] result = new int[length][length];

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (matrix1[i][j] == 1 || matrix2[i][j] == 1)
                {
                    result[i][j] = 1;
                }
            }
        }

        return result;
    }
}
