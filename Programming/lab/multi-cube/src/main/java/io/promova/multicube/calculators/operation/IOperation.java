package io.promova.multicube.calculators.operation;

public interface IOperation
{
    public double execute(double[] operands);
    public int getNumberOfParams();
}