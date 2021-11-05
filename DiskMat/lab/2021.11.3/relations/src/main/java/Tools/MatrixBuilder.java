package Tools;

public class MatrixBuilder implements IMatrixBuilder
{
    @Override
    public int[][] identityMatrix(int length)
    {
        int[][] identityMatrix = new int[length][length];

        for (int i = 0; i < length; i++)
        {
            identityMatrix[i][i] = 1;
        }

        return identityMatrix;
    }

    @Override
    public int[][] invertibleMatrix(int[][] matrix)
    {
        int length = matrix.length;

        int[][] invertedMatrix = new int[length][length];

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                invertedMatrix[i][j] = matrix[j][i];
            }
        }

        return invertedMatrix;
    }
}
