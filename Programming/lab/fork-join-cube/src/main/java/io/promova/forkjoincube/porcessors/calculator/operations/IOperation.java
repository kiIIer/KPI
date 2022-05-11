package io.promova.forkjoincube.porcessors.calculator.operations;

public interface IOperation
{
    double calculate(double[] operands);

    int getNumberOfParams();
}
