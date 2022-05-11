package io.promova.forkjoincube.util;

public class MutableDouble
{
    private Double value;

    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    public MutableDouble(Double value)
    {
        this.value = value;
    }

    public MutableDouble()
    {
    }
}
