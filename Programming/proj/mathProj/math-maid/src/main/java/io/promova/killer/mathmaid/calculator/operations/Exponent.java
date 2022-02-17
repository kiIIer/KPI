package io.promova.killer.mathmaid.calculator.operations;

public class Exponent implements IOperation
{
    @Override
    public double execute(double[] operands)
    {
        return Math.pow(operands[0], operands[1]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 2;
    }
}
