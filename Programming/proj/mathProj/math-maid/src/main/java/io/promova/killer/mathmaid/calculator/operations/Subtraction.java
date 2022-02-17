package io.promova.killer.mathmaid.calculator.operations;

public class Subtraction implements IOperation
{
    @Override
    public double execute(double[] operands)
    {
        return operands[0] - operands[1];
    }

    @Override
    public int getNumberOfParams()
    {
        return 2;
    }
}
