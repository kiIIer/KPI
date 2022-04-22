package io.promova.multicube.models;

public class Parameter
{
    private String name;
    private double lowBound;
    private double highBound;
    private double step;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getLowBound()
    {
        return lowBound;
    }

    public void setLowBound(double lowBound)
    {
        this.lowBound = lowBound;
    }

    public double getHighBound()
    {
        return highBound;
    }

    public void setHighBound(double highBound)
    {
        this.highBound = highBound;
    }

    public double getStep()
    {
        return step;
    }

    public void setStep(double step)
    {
        this.step = step;
    }

    public Parameter(String name, double lowBound, double highBound, double step)
    {
        this.name = name;
        this.lowBound = lowBound;
        this.highBound = highBound;
        this.step = step;
    }

    public Parameter()
    {
    }

    public int getIterations()
    {
        return (int) ((highBound - lowBound) / step);
    }

    public double getValue(int i)
    {
        return lowBound + step * i;
    }
}
