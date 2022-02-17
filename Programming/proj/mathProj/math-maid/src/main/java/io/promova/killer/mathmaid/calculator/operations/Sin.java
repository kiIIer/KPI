package io.promova.killer.mathmaid.calculator.operations;

public class Sin implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return Math.sin(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
