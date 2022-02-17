package io.promova.killer.mathmaid.calculator.operations;

public class Sqrt implements IOperation
{
    @Override
    public double execute(double[] operands)
    {
        return Math.sqrt(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
