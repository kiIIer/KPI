package io.promova.killer.mathmaid.calculator.operations;

public class Tan implements IOperation
{
    @Override
    public double execute(double[] operands)
    {
        return Math.tan(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
