package Tools;

import Tree.Action;

import java.util.HashMap;
import java.util.Map;

public class StringToAction
{
    public static Map<String, Action> actions;

    static
    {
        actions = new HashMap<>();

        actions.put("+", Action.ADDITION);
        actions.put("-", Action.SUBTRACTION);
        actions.put("*", Action.MULTIPLICATION);
        actions.put("/", Action.DIVISION);
        actions.put("^", Action.EXPONENTIATION);
    }
}
