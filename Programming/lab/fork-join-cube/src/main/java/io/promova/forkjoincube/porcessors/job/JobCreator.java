package io.promova.forkjoincube.porcessors.job;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.models.logic.Parameter;

import java.util.*;

public class JobCreator implements IJobCreator
{
    @Override
    public List<CalculateJob> create(List<Parameter> parameters)
    {
        Deque<ParamStatus> paramStatuses = new LinkedList<>();
        List<CalculateJob> jobs = new LinkedList<>();
        parameters.sort(Comparator.comparing(Parameter::name));

        compute(parameters, paramStatuses, jobs);

        return jobs;
    }

    private void compute(List<Parameter> parameters, Deque<ParamStatus> paramStatuses, List<CalculateJob> jobs)
    {
        if (parameters.size() == paramStatuses.size())
        {
            Map<String, Double> map = new HashMap<>();
            paramStatuses.forEach(paramStatus -> map.put(paramStatus.name(), paramStatus.value()));

            Double resultLink = 0.0;
            jobs.add(new CalculateJob(map, resultLink));
            return;
        }

        Parameter currentParameter = parameters.get(paramStatuses.size());
//        for (int i = 0; i < currentParameter.iterations(); i++)
//        {
//            paramStatuses.push(new ParamStatus(i, currentParameter));
//            compute(parameters, paramStatuses, jobs);
//            paramStatuses.pop();
//        }
        for (Double value : currentParameter.values())
        {
            paramStatuses.push(new ParamStatus(value, currentParameter.name()));
            compute(parameters, paramStatuses, jobs);
            paramStatuses.pop();
        }

    }

    private record ParamStatus(double value, String name)
    {
    }
}

