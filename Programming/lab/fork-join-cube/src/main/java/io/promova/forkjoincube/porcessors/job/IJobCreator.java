package io.promova.forkjoincube.porcessors.job;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.models.logic.Parameter;

import java.util.List;

public interface IJobCreator
{
    List<CalculateJob> create(List<Parameter> parameters, Formula formula);
}
