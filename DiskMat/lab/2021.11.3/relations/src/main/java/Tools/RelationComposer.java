package Tools;

public class RelationComposer implements IRelationComposer
{
    @Override
    public int[][] compose(int[][] matrix1, int[][] matrix2)
    {
        int length = matrix1.length;

        int[][] composition = new int[length][length];

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                for (int k = 0; k < length; k++)
                {
                    if (matrix1[i][k] == 1 && matrix2[k][j] == 1)
                    {
                        composition[i][j] = 1;
                        break;
                    }
                }
            }
        }

        return composition;
    }
}
