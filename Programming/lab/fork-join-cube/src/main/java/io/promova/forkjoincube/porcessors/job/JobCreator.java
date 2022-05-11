package io.promova.forkjoincube.porcessors.job;

import io.promova.forkjoincube.models.logic.CalculateJob;
import io.promova.forkjoincube.models.logic.Dimension;
import io.promova.forkjoincube.models.logic.Formula;
import io.promova.forkjoincube.models.logic.Parameter;

import java.util.*;
import java.util.function.DoubleConsumer;

public class JobCreator implements IJobCreator
{
    @Override
    public List<CalculateJob> create(List<Parameter> parameters, Formula formula, Dimension dimension)
    {
        Deque<ParamStatus> paramStatuses = new LinkedList<>();
        List<CalculateJob> jobs = new LinkedList<>();
        parameters.sort(Comparator.comparing(Parameter::name));

        compute(parameters, paramStatuses, jobs, formula, dimension);

        return jobs;
    }

    private void compute(List<Parameter> parameters, Deque<ParamStatus> paramStatuses, List<CalculateJob> jobs, Formula formula, Dimension dimension)
    {
        if (parameters.size() == paramStatuses.size())
        {
            Map<String, Double> map = new HashMap<>();
            paramStatuses.forEach(paramStatus -> map.put(paramStatus.name(), paramStatus.value()));

            DoubleConsumer resultLink = dimension::setValue;
            jobs.add(new CalculateJob(map, resultLink, formula));
            return;
        }

        Parameter currentParameter = parameters.get(paramStatuses.size());

        dimension.setParameterName(currentParameter.name());

            dimension.setDimensions(new HashMap<>());
        for (Double value : currentParameter.values())
        {
            paramStatuses.push(new ParamStatus(value, currentParameter.name()));
            Dimension subDimension = new Dimension();
            dimension.getDimensions().put(value, subDimension);
            compute(parameters, paramStatuses, jobs, formula, subDimension);
            paramStatuses.pop();
        }

    }

    private record ParamStatus(double value, String name)
    {
    }
}

