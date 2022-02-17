package io.promova.killer.mathmaid.util;

public class Counter implements ICounter
{
    private int counter = 0;

    @Override
    public int getCounter()
    {
        return counter;
    }

    @Override
    public void increment()
    {
        counter++;
    }
}
