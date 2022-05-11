package io.promova.forkjoincube.porcessors.calculator;

import io.promova.forkjoincube.porcessors.calculator.operations.IOperation;

import java.util.Map;

public interface IFormula
{
    IOperation getOperation();

    void setOperation(IOperation operation);

    IFormula[] getFormulas();

    void setFormulas(IFormula[] formulas);

    String getParamName();

    Double getConstant();

    void setParamName(String paramName);

    void setConstant(Double constant);

    double compute(Map<String, Double> params);
}

