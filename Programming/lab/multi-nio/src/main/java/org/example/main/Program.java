package org.example.main;

import org.example.fileworker.*;

import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Program implements IProgram
{
    private final IJobCreator jobCreator;

    @Inject
    public Program(IJobCreator jobCreator)
    {
        this.jobCreator = jobCreator;
    }

    @Override
    public void execute(String[] args) throws Exception
    {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        List<File> files = Arrays.stream(args).map(File::new).toList();
        Statistic statistics = new Statistic();
        List<Job> jobs = jobCreator.create(files, statistics);
        StatisticFormer statisticFormer = new StatisticFormer(jobs);
        forkJoinPool.invoke(statisticFormer);
        for (StatisticUnit statisticUnit : statistics.getList())
        {
            System.out.println(statisticUnit);
        }
    }
}
