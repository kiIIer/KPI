package io.promova.killer.mathmaid.calculator.operations;

public class Ln implements IOperation
{

    @Override
    public double execute(double[] operands)
    {
        return Math.log(operands[0]);
    }

    @Override
    public int getNumberOfParams()
    {
        return 1;
    }
}
