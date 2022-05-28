package io.promova.multicube.calculators;

import io.promova.multicube.calculators.operation.IOperation;

import java.util.Map;


public class Formula
{
    private IOperation operation;
    private Formula[] formulas;


    private Double constant = null;
    private String paramName;

    public IOperation getOperation()
    {
        return operation;
    }

    public void setOperation(IOperation operation)
    {
        this.operation = operation;
    }

    public Formula[] getFormulas()
    {
        return formulas;
    }

    public void setFormulas(Formula[] formulas)
    {
        this.formulas = formulas;
    }

    public String getParamName()
    {
        return paramName;
    }

    public Double getConstant()
    {
        return constant;
    }

    public void setParamName(String paramName)
    {
        this.paramName = paramName;
    }

    public void setConstant(Double constant)
    {
        this.constant = constant;
    }

}