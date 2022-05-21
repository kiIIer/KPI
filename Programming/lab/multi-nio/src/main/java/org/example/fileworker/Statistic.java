package org.example.fileworker;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Statistic
{
    private final List<StatisticUnit> filesStatistics;
    private final Lock lock;

    public Statistic()
    {
        this.lock = new ReentrantLock();
        this.filesStatistics = new LinkedList<>();
    }

    public void add(StatisticUnit statisticUnit)
    {
        lock.lock();
        try
        {
            filesStatistics.add(statisticUnit);
        } finally
        {
            lock.unlock();
        }
    }

    public List<StatisticUnit> getList()
    {
        lock.lock();
        try
        {
            return this.filesStatistics;
        } finally
        {
            lock.unlock();
        }
    }
}
