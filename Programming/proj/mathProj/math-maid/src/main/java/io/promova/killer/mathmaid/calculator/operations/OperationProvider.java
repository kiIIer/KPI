package io.promova.killer.mathmaid.calculator.operations;

import java.util.HashMap;
import java.util.Map;

public class OperationProvider implements IOperationProvider
{
    Map<String, IOperation> map;

    public OperationProvider(
            Abs abs,
            Acos acos,
            Acot acot,
            Addition addition,
            Asin asin,
            Atan atan,
            Ch ch,
            Cos cos,
            Cot cot,
            Division division,
            Exp exp,
            Exponent exponent,
            Ln ln,
            Multiplication multiplication,
            Sh sh,
            Sin sin,
            Sqrt sqrt,
            Subtraction subtraction,
            Tan tan,
            Th th

    )
    {
        map = new HashMap<>();

        map.put("abs", abs);
        map.put("acos", acos);
        map.put("acot", acot);
        map.put("+", addition);
        map.put("asin", asin);
        map.put("atan", atan);
        map.put("ch", ch);
        map.put("cos", cos);
        map.put("cot", cot);
        map.put("/", division);
        map.put("exp", exp);
        map.put("^", exponent);
        map.put("ln", ln);
        map.put("*", multiplication);
        map.put("sh", sh);
        map.put("sin", sin);
        map.put("sqrt", sqrt);
        map.put("-", subtraction);
        map.put("tan", tan);
        map.put("th", th);
    }

    @Override
    public IOperation getOperation(String key)
    {
        return map.get(key);
    }
}
