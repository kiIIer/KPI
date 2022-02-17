package io.promova.killer.mathmaid.calculator.operations;

public class Acot implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return 1 / Math.atan(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
