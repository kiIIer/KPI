package io.promova.forkjoincube.porcessors.job;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.models.logic.Parameter;
import io.promova.forkjoincube.util.MutableDouble;

import java.util.*;

public class JobCreator implements IJobCreator
{
    @Override
    public List<CalculateJob> create(List<Parameter> parameters, Formula formula)
    {
        Deque<ParamStatus> paramStatuses = new LinkedList<>();
        List<CalculateJob> jobs = new LinkedList<>();
        parameters.sort(Comparator.comparing(Parameter::name));

        compute(parameters, paramStatuses, jobs, formula);

        return jobs;
    }

    private void compute(List<Parameter> parameters, Deque<ParamStatus> paramStatuses, List<CalculateJob> jobs, Formula formula)
    {
        if (parameters.size() == paramStatuses.size())
        {
            Map<String, Double> map = new HashMap<>();
            paramStatuses.forEach(paramStatus -> map.put(paramStatus.name(), paramStatus.value()));

            MutableDouble resultLink = new MutableDouble(0.0);
            jobs.add(new CalculateJob(map, resultLink, formula));
            return;
        }

        Parameter currentParameter = parameters.get(paramStatuses.size());

        for (Double value : currentParameter.values())
        {
            paramStatuses.push(new ParamStatus(value, currentParameter.name()));
            compute(parameters, paramStatuses, jobs, formula);
            paramStatuses.pop();
        }

    }

    private record ParamStatus(double value, String name)
    {
    }
}

