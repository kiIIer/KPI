package io.promova.killer.mathmaid.calculator.operations;

public class Cot implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return 1 / Math.tan(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
