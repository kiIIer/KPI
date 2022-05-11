package io.promova.forkjoincube.porcessors.cube;

import io.promova.forkjoincube.models.logic.CalculateJob;

import java.util.List;

public interface IRecursiveFormerFactory
{
    RecursiveFormer create(List<CalculateJob> workload);
}
