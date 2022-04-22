package io.promova.multicube.tools.validators;

import io.promova.multicube.calculators.OperationsMap;
import io.promova.multicube.calculators.operation.IOperation;
import io.promova.multicube.models.HypercubeRequest;
import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HaveAllDataValidator implements IHaveAllDataValidator
{
    private final OperationsMap map;

    public HaveAllDataValidator(
            OperationsMap map
    )
    {
        this.map = map;
    }

    @Override
    public List<APISubError> validate(HypercubeRequest object)
    {
        List<APISubError> errors = new ArrayList<>();

        String[] elements = object.getPolish().split(" ");
        List<String> vars = Arrays.stream(elements).filter(element ->
        {
            for (String reserved : map.keySet())
            {
                if (element.equals(reserved))
                {
                    return false;
                }
            }
            return true;
        }).toList();

        if (vars.size() != object.getParameters().size())
        {
            return List.of(new APISubError("Missing or extra variables"));
        }

        for (String variable : vars)
        {
            boolean provided = false;
            for (Parameter parameter : object.getParameters())
            {
                if (parameter.getName().equals(variable))
                {
                    provided = true;
                    break;
                }
            }
            if (!provided)
            {
                return List.of(new APISubError("Missing variable " + variable));
            }
        }

        return List.of();
    }
}
