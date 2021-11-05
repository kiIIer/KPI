package Tools;

import com.google.inject.Inject;

public class TransitiveClosurer implements ITransitiveClosurer
{
    private final IRelationComposer relationComposer;
    private final IMatrixUnioner matrixUnioner;

    @Inject
    public TransitiveClosurer(IRelationComposer relationComposer, IMatrixUnioner matrixUnioner)
    {
        this.relationComposer = relationComposer;
        this.matrixUnioner = matrixUnioner;
    }

    @Override
    public int[][] calculate(int[][] matrix)
    {
        int length = matrix.length;

        int[][] result = matrix.clone();
        for (int i = 1; i <= length; i++)
        {
            result = matrixUnioner.calculate(result, caclPower(i, matrix));
        }

        return result;
    }

    private int[][] caclPower(int power, int[][] matrix)
    {
        int[][] composition = matrix.clone();

        for (int i = 1; i < power; i++)
        {
            composition = relationComposer.compose(composition, matrix);
        }
        return composition;
    }
}
