package Tree.Calculator;

import ArActions.*;
import Tree.Action;
import Tree.IBranch;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class BranchCalculator implements IBranchCalculator
{
    public Map<Action, IArAction> actions;

    @Inject
    public BranchCalculator(
            IAddition addition,
            ISubtraction subtraction,
            IMultiplication multiplication,
            IDivision division,
            IExponentiation exponentiation
    )
    {
        actions = new HashMap<>();

        actions.put(Action.ADDITION, addition);
        actions.put(Action.SUBTRACTION, subtraction);
        actions.put(Action.MULTIPLICATION, multiplication);
        actions.put(Action.DIVISION, division);
        actions.put(Action.EXPONENTIATION, exponentiation);
    }

    @Override
    public double calculate(IBranch branch)
    {
        Double number = branch.getNumber();
        if (number != null)
        {
            return number;
        }

        Action action = branch.getAction();

        IArAction arAction = actions.get(action);

        return arAction.apply(calculate(branch.getLeftBranch()), calculate(branch.getRightBranch()));
    }
}
