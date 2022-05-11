package io.promova.forkjoincube.porcessors.calculator.operations;

public interface IOperation
{
    double execute(double[] operands);

    int getNumberOfParams();

    String getSymbol();
}
