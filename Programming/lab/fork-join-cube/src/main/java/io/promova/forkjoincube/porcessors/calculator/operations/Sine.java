package io.promova.forkjoincube.porcessors.calculator.operations;

public class Sine implements IOperation
{
    public static final String SYMBOL = "sin";

    @Override
    public double calculate(double[] operands)
    {
        return Math.sin(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
