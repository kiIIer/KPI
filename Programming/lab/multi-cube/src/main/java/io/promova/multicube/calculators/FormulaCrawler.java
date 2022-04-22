package io.promova.multicube.calculators;

import java.util.Map;

public class FormulaCrawler implements IFormulaCrawler
{
    @Override
    public double compute(Formula formula, Map<String, Double> params)
    {
        if (formula.getOperation() == null)
        {
            if (formula.getConstant() == null)
            {
                return params.get(formula.getParamName());
            } else
            {
                return formula.getConstant();
            }
        }

        double[] operands = new double[formula.getFormulas().length];
        Formula[] formulas = formula.getFormulas();

        for (int i = 0; i < operands.length; i++)
        {
            operands[i] = compute(formulas[i], params);
        }

        return formula.getOperation().execute(operands);
    }
}
