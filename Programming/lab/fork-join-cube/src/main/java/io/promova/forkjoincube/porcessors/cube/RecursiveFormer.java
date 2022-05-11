package io.promova.forkjoincube.porcessors.cube;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.porcessors.calculator.IFormulaCrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class RecursiveFormer extends RecursiveAction
{
    private final List<CalculateJob> workload;
    private static final int THRESHOLD = 20;
    private final IFormulaCrawler formulaCrawler;
    private final IRecursiveFormerFactory factory;

    public RecursiveFormer(List<CalculateJob> workload, IFormulaCrawler formulaCrawler, IRecursiveFormerFactory factory)
    {
        this.workload = workload;
        this.formulaCrawler = formulaCrawler;
        this.factory = factory;
    }

    @Override
    protected void compute()
    {
        if (workload.size() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            processing(workload);
        }
    }

    private List<RecursiveFormer> createSubtasks()
    {
        List<RecursiveFormer> subtasks = new ArrayList<>();

        List<CalculateJob> partOne = workload.subList(0, workload.size() / 2);
        List<CalculateJob> partTwo = workload.subList(workload.size() / 2, workload.size() - 1);

        subtasks.add(factory.create(partOne));
        subtasks.add(factory.create(partTwo));

        return subtasks;
    }

    private void processing(List<CalculateJob> work)
    {
        for (CalculateJob job : work)
        {
            job.resultLink().setValue(formulaCrawler.compute(job.formula(), job.parameters()));
        }
    }
}
