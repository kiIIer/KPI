package io.promova.killer.mathmaid.calculator.operations;

public class Ch implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return Math.cosh(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
