package io.promova.killer.mathmaid.calculator.operations;

public class Exp implements IOperation
{
    @Override
    public double execute(double[] operands)
    {
        return Math.exp(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
