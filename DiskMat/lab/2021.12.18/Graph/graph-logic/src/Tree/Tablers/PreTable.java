package Tree.Tablers;

import Tree.Calculator.IBranchCalculator;
import Tree.IBranch;
import Tree.ToStringers.IPrefixToString;

import javax.inject.Inject;

public class PreTable implements IPreTable
{

    private final IPrefixToString prefixToString;
    private final IBranchCalculator branchCalculator;

    @Inject
    public PreTable(
            IPrefixToString prefixToString,
            IBranchCalculator branchCalculator
    )
    {
        this.prefixToString = prefixToString;
        this.branchCalculator = branchCalculator;
    }

    @Override
    public void generate(IBranch branch, StringBuilder sb)
    {
        sb.append("Calculating ");
        sb.append(prefixToString.toString(branch));
        sb.append(" , ");

        IBranch leftBranch = branch.getLeftBranch();
        IBranch rightBranch = branch.getRightBranch();

        if (leftBranch == null || rightBranch == null)
        {
            sb.append("So, ");
            sb.append(prefixToString.toString(branch));
            sb.append(" = ");
            sb.append(branchCalculator.calculate(branch));
            return;
        }

        sb.append("Need to calculate ");
        sb.append(prefixToString.toString(leftBranch));
        sb.append(" , ");
        sb.append("Need to calculate ");
        sb.append(prefixToString.toString(rightBranch));
        sb.append(" , ");

        sb.append("\n");
        generate(leftBranch, sb);
        sb.append("\n");
        sb.append(prefixToString.toString(leftBranch));
        sb.append(" = ");
        sb.append(branchCalculator.calculate(leftBranch));
        sb.append("\n");
        generate(rightBranch, sb);
        sb.append("\n");
        sb.append(prefixToString.toString(rightBranch));
        sb.append(" = ");
        sb.append(branchCalculator.calculate(rightBranch));
        sb.append("\n");
        sb.append("So, ");
        sb.append(prefixToString.toString(branch));
        sb.append(" = ");
        sb.append(branchCalculator.calculate(branch));
    }
}
