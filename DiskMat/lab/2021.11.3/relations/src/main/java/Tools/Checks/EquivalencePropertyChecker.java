package Tools.Checks;

import com.google.inject.Inject;

public class EquivalencePropertyChecker implements IEquivalencePropertyChecker
{
    private final IReflexivePropertyChecker reflexivePropertyChecker;
    private final ISymmetricPropertyChecker symmetricPropertyChecker;
    private final ITransitivePropertyChecker transitivePropertyChecker;

    @Inject
    public EquivalencePropertyChecker(
            IReflexivePropertyChecker reflexivePropertyChecker,
            ISymmetricPropertyChecker symmetricPropertyChecker,
            ITransitivePropertyChecker transitivePropertyChecker
    )
    {
        this.reflexivePropertyChecker = reflexivePropertyChecker;
        this.symmetricPropertyChecker = symmetricPropertyChecker;
        this.transitivePropertyChecker = transitivePropertyChecker;
    }

    @Override
    public boolean check(int[][] matrix)
    {
        if (!reflexivePropertyChecker.check(matrix))
        {
            return false;
        }
        if (!symmetricPropertyChecker.check(matrix))
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
