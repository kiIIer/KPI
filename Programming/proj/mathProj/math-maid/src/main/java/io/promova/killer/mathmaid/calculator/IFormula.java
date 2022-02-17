package io.promova.killer.mathmaid.calculator;

import java.util.Map;

public interface IFormula
{
    io.promova.killer.mathmaid.calculator.operations.IOperation getOperation();

    void setOperation(io.promova.killer.mathmaid.calculator.operations.IOperation operation);

    IFormula[] getFormulas();

    void setFormulas(IFormula[] formulas);

    String getParamName();

    Double getConstant();

    void setParamName(String paramName);

    void setConstant(Double constant);

    double compute(Map<String, Double> params);
}
