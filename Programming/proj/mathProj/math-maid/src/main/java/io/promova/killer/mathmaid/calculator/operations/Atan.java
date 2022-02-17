package io.promova.killer.mathmaid.calculator.operations;

public class Atan implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return Math.atan(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
