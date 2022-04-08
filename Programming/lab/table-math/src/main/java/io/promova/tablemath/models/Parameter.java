package io.promova.tablemath.models;

public class Parameter
{
    private String name;
    private long lowerBound;
    private long upperBound;
    private long step;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getLowerBound()
    {
        return lowerBound;
    }

    public void setLowerBound(long lowerBound)
    {
        this.lowerBound = lowerBound;
    }

    public long getUpperBound()
    {
        return upperBound;
    }

    public void setUpperBound(long upperBound)
    {
        this.upperBound = upperBound;
    }

    public long getStep()
    {
        return step;
    }

    public void setStep(long step)
    {
        this.step = step;
    }

    public int getIters()
    {
        return (int) ((upperBound - lowerBound) / step);
    }

    public Parameter(String name, long lowerBound, long upperBound, long step)
    {
        this.name = name;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.step = step;
    }

    public Parameter()
    {
    }
}
