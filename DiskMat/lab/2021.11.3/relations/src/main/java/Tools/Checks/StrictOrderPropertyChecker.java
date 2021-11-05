package Tools.Checks;

import com.google.inject.Inject;

public class StrictOrderPropertyChecker implements IStrictOrderPropertyChecker
{
    private final IIrreflexivePropertyChecker irreflexivePropertyChecker;
    private final IAntiSymmetricPropertyChecker antiSymmetricPropertyChecker;
    private final ITransitivePropertyChecker transitivePropertyChecker;

    @Inject
    public StrictOrderPropertyChecker(
            IIrreflexivePropertyChecker irreflexivePropertyChecker,
            IAntiSymmetricPropertyChecker antiSymmetricPropertyChecker,
            ITransitivePropertyChecker transitivePropertyChecker
    )
    {
        this.irreflexivePropertyChecker = irreflexivePropertyChecker;
        this.antiSymmetricPropertyChecker = antiSymmetricPropertyChecker;
        this.transitivePropertyChecker = transitivePropertyChecker;
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
        if (!transitivePropertyChecker.check(matrix))
        {
            return false;
        }

        return true;

    }
}
