package io.promova.killer.mathmaid.calculator.operations;

public class Sh implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return Math.sinh(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
