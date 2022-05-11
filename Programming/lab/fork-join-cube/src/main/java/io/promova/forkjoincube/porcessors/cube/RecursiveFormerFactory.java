package io.promova.forkjoincube.porcessors.cube;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.porcessors.calculator.IFormulaCrawler;

import java.util.List;

public class RecursiveFormerFactory implements IRecursiveFormerFactory
{
    private final IFormulaCrawler formulaCrawler;

    public RecursiveFormerFactory(IFormulaCrawler formulaCrawler)
    {
        this.formulaCrawler = formulaCrawler;
    }

    @Override
    public RecursiveFormer create(List<CalculateJob> workload)
    {
        return new RecursiveFormer(workload, formulaCrawler, this);
    }
}
