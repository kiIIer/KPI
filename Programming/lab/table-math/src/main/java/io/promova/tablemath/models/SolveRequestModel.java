package io.promova.tablemath.models;


import org.springframework.lang.NonNull;

public class SolveRequestModel
{
    private Parameter paramA;
    private Parameter paramB;

    public Parameter getParamA()
    {
        return paramA;
    }

    public void setParamA(Parameter paramA)
    {
        this.paramA = paramA;
    }

    public Parameter getParamB()
    {
        return paramB;
    }

    public void setParamB(Parameter paramB)
    {
        this.paramB = paramB;
    }

    public SolveRequestModel(Parameter paramA, Parameter paramB)
    {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public SolveRequestModel()
    {
    }
}
