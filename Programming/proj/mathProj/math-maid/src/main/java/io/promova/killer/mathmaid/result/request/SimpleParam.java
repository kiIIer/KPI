package io.promova.killer.mathmaid.result.request;

import jakarta.validation.constraints.NotNull;

public class SimpleParam
{
    private double value;

    @NotNull
    private String name;

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
