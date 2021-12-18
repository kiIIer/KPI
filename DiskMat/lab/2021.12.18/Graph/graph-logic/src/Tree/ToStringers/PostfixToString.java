package Tree.ToStringers;

import Tree.IBranch;

public class PostfixToString implements IPostfixToString
{
    @Override
    public String toString(IBranch branch)
    {
        StringBuilder sb = new StringBuilder();

        IBranch leftBranch = branch.getLeftBranch();
        IBranch rightBranch = branch.getRightBranch();

        if (leftBranch == null || rightBranch == null)
        {
            sb.append(branch.getNumber());
            sb.append(" ");
            return sb.toString();
        }

        sb.append(toString(leftBranch));
        sb.append(toString(rightBranch));

        sb.append(branch.getContent());
        sb.append(" ");
        return sb.toString();
    }
}
