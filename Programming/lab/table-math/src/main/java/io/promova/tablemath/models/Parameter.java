package io.promova.tablemath.models;

public class Parameter
{
    private long lowerBound;
    private long upperBound;
    private long step;

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

    public int getIterations()
    {
        return (int) ((upperBound - lowerBound) / step);
    }

    public long getValue(int i)
    {
        return lowerBound + step * i;
    }

    public Parameter(long lowerBound, long upperBound, long step)
    {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.step = step;
    }

    public Parameter()
    {
    }
}
