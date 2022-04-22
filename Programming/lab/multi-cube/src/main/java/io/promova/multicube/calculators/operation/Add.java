package io.promova.multicube.calculators.operation;

public class Add implements IAdd
{

    @Override
    public double execute(double[] operands)
    {
        return operands[0] + operands[1];
    }

    @Override
    public int getNumberOfParams()
    {
        return 2;
    }

    @Override
    public String getSymbol()
    {
        return "+";
    }
}
