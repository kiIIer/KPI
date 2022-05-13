package io.promova.forkjoincube.porcessors.calculator.operations;

public class Division implements IOperation
{
    public static final String SYMBOL = "/";

    @Override
    public double calculate(double[] operands)
    {
        return operands[0] / operands[1];
    }

    @Override
    public int getNumberOfParams()
    {
        return 2;
    }
}
