package Tools;

import com.google.inject.Inject;

public class SymmetricClosurer implements ISymmetricClosurer
{

    private final IMatrixUnioner matrixUnioner;
    private final IMatrixBuilder matrixBuilder;

    @Inject
    public SymmetricClosurer(IMatrixUnioner matrixUnioner, IMatrixBuilder matrixBuilder)
    {
        this.matrixUnioner = matrixUnioner;
        this.matrixBuilder = matrixBuilder;
    }

    @Override
    public int[][] calculate(int[][] matrix)
    {
        int length = matrix.length;

        return matrixUnioner.calculate(matrix, matrixBuilder.invertibleMatrix(matrix));
    }
}
