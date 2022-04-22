package io.promova.multicube.calculators.operation;

public interface IAdd extends IOperation
{
    @Override
    double execute(double[] operands);

    @Override
    int getNumberOfParams();
}
