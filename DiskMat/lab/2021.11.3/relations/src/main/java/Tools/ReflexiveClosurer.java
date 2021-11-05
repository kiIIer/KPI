package Tools;

import com.google.inject.Inject;

public class ReflexiveClosurer implements IReflexiveClosurer
{

    private final IMatrixUnioner matrixUnioner;
    private final IMatrixBuilder matrixBuilder;

    @Inject
    public ReflexiveClosurer(IMatrixUnioner matrixUnioner, IMatrixBuilder matrixBuilder)
    {
        this.matrixUnioner = matrixUnioner;
        this.matrixBuilder = matrixBuilder;
    }

    @Override
    public int[][] calculate(int[][] matrix)
    {
        int length = matrix.length;

        return matrixUnioner.calculate(matrix, matrixBuilder.identityMatrix(length));
    }
}
