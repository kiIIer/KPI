package Tree.Tablers;

import Tree.Calculator.IBranchCalculator;
import Tree.IBranch;
import Tree.ToStringers.IPostfixToString;

import javax.inject.Inject;

public class PostTable implements IPostTable
{
    private final IBranchCalculator branchCalculator;
    private final IPostfixToString prefixToString;

    @Inject
    public PostTable(
            IBranchCalculator branchCalculator,
            IPostfixToString postfixToString
    )
    {
        this.branchCalculator = branchCalculator;
        this.prefixToString = postfixToString;
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
