package io.promova.killer.mathmaid.calculator.operations;

public interface IOperation
{
    public double execute(double[] operands);
    public int getNumberOfParams();
}
