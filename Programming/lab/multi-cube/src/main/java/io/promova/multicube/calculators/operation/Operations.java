package io.promova.multicube.calculators.operation;

public enum Operations
{
    ADDITION("+");

    private final String symbol;

    public String getSymbol()
    {
        return symbol;
    }

    Operations(String symbol)
    {
        this.symbol = symbol;
    }


}
