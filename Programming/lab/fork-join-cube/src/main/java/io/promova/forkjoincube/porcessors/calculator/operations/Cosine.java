package io.promova.forkjoincube.porcessors.calculator.operations;

public class Cosine implements IOperation
{
    public static final String SYMBOL = "cos";

    @Override
    public double calculate(double[] operands)
    {
        return Math.cos(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
