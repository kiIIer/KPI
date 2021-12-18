package Tree.ToStringers;

import Tree.IBranch;

public class PrefixToString implements IPrefixToString
{
    @Override
    public String toString(IBranch branch)
    {
        StringBuilder sb = new StringBuilder();

        Double number = branch.getNumber();
        if (number != null)
        {
            sb.append(number);
            sb.append(" ");
            return sb.toString();
        }

        String action = (String) branch.getContent();
        sb.append(action);
        sb.append(" ");

        sb.append(toString(branch.getLeftBranch()));
        sb.append(toString(branch.getRightBranch()));

        return sb.toString();
    }
}
