package Tools.Checks;

import com.google.inject.Inject;

public class AsymmetricPropertyChecker implements IAsymmetricPropertyChecker
{
    private final IIrreflexivePropertyChecker irreflexivePropertyChecker;
    private final IAntiSymmetricPropertyChecker antiSymmetricPropertyChecker;

    @Inject
    public AsymmetricPropertyChecker(
            IIrreflexivePropertyChecker irreflexivePropertyChecker,
            IAntiSymmetricPropertyChecker antiSymmetricPropertyChecker
    )
    {
        this.irreflexivePropertyChecker = irreflexivePropertyChecker;
        this.antiSymmetricPropertyChecker = antiSymmetricPropertyChecker;
    }

    @Override
    public boolean check(int[][] matrix)
    {
        if (!irreflexivePropertyChecker.check(matrix))
        {
            return false;
        }

        if (!antiSymmetricPropertyChecker.check(matrix))
        {
            return false;
        }

        return true;
    }
}
