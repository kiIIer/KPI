package io.promova.multicube.calculators.operation;

public interface ISubtract extends IOperation
{
    @Override
    double execute(double[] operands);

    @Override
    int getNumberOfParams();

    @Override
    String getSymbol();
}
