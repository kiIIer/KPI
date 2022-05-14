package io.promova.forkjoincube.porcessors.calculator;

import io.promova.forkjoincube.models.logic.Formula;

import java.util.Map;

public class FormulaCrawler implements IFormulaCrawler
{
    @Override
    public double compute(Formula formula, Map<String, Double> params)
    {
        if (formula.operation() == null)
        {
            if (formula.constant() == null)
            {
                return params.get(formula.paramName());
            } else
            {
                return formula.constant();
            }
        }

        double[] operands = new double[formula.formulas().length];
        Formula[] formulas = formula.formulas();

        for (int i = 0; i < operands.length; i++)
        {
            operands[i] = compute(formulas[i], params);
        }

        return formula.operation().calculate(operands);
    }
}
