package Tree;

import java.util.Arrays;

public class TreeFromString implements ITreeFromString
{
    @Override
    public IBranch translate(String math)
    {
        String[] equation = math.split(" ");

        return split(equation);
    }

    private Branch split(String[] equation)
    {
        int bracketCount = 0;
        String[] branchA = null;
        String[] branchB = null;
        String action = null;

        if (equation.length == 1)
        {
            Branch branch = new Branch();
            branch.setNumber(Double.parseDouble(equation[0]));
            return branch;
        }

        for (int i = 0; i < equation.length; i++)
        {
            if (equation[i].equals("("))
            {
                bracketCount++;
            }
            if (equation[i].equals(")"))
            {
                bracketCount--;
            }

            if (bracketCount == 0)
            {
                branchA = Arrays.copyOfRange(equation, 1, i);
                branchB = Arrays.copyOfRange(equation, i + 3, equation.length - 1);
                action = equation[i + 1];
                break;
            }
        }

        Branch branch = new Branch();
        branch.setAction(action);
        branch.setLeftBranch(split(branchA));
        branch.setRightBranch(split(branchB));

        return branch;
    }
}
