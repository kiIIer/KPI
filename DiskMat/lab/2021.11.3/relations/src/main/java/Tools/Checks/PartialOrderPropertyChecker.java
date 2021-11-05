package Tools.Checks;

import com.google.inject.Inject;

public class PartialOrderPropertyChecker implements IPartialOrderPropertyChecker
{
    private final IReflexivePropertyChecker reflexivePropertyChecker;
    private final IAntiSymmetricPropertyChecker antiSymmetricPropertyChecker;
    private final ITransitivePropertyChecker transitivePropertyChecker;

    @Inject
    public PartialOrderPropertyChecker(
            IReflexivePropertyChecker reflexivePropertyChecker,
            IAntiSymmetricPropertyChecker antiSymmetricPropertyChecker,
            ITransitivePropertyChecker transitivePropertyChecker
    )
    {
        this.reflexivePropertyChecker = reflexivePropertyChecker;
        this.antiSymmetricPropertyChecker = antiSymmetricPropertyChecker;
        this.transitivePropertyChecker = transitivePropertyChecker;
    }

    @Override
    public boolean check(int[][] matrix)
    {
        if (!reflexivePropertyChecker.check(matrix))
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
