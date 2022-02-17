package io.promova.killer.mathmaid.calculator.operations;

public class Asin implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return Math.asin(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
