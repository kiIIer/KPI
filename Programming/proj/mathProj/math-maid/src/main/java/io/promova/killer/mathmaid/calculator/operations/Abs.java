package io.promova.killer.mathmaid.calculator.operations;

public class Abs implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return Math.abs(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
