package io.promova.multicube.calculators.operation;

public interface IOperation
{
    double execute(double[] operands);

    int getNumberOfParams();

    String getSymbol();
}