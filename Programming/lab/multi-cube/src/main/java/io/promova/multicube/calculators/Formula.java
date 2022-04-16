package io.promova.multicube.calculators;

import io.promova.multicube.calculators.operation.IOperation;

import java.util.Map;

public class Formula implements IFormula
{
    private IOperation operation;
    private IFormula[] formulas;

    private Double constant = null;
    private String paramName;

    @Override
    public IOperation getOperation()
    {
        return operation;
    }

    @Override
    public void setOperation(IOperation operation)
    {
        this.operation = operation;
    }

    @Override
    public IFormula[] getFormulas()
    {
        return formulas;
    }

    @Override
    public void setFormulas(IFormula[] formulas)
    {
        this.formulas = formulas;
    }

    @Override
    public String getParamName()
    {
        return paramName;
    }

    @Override
    public Double getConstant()
    {
        return constant;
    }

    @Override
    public void setParamName(String paramName)
    {
        this.paramName = paramName;
    }

    @Override
    public void setConstant(Double constant)
    {
        this.constant = constant;
    }

    @Override
    public double compute(Map<String, Double> params)
    {
        if (operation == null)
        {
            if (constant == null)
            {
                return params.get(paramName);
            } else
            {
                return constant;
            }
        }

        double[] operands = new double[formulas.length];

        for (int i = 0; i < operands.length; i++)
        {
            operands[i] = formulas[i].compute(params);
        }

        return operation.execute(operands);
    }
}