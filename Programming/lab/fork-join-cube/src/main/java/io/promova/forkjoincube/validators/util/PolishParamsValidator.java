package io.promova.forkjoincube.validators.util;

import io.promova.forkjoincube.models.logic.Parameter;
import io.promova.forkjoincube.porcessors.calculator.operations.IOperation;
import io.promova.forkjoincube.porcessors.calculator.operations.IOperationsMap;
import io.promova.forkjoincube.porcessors.calculator.operations.OperationsMap;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.util.Tuple;
import io.promova.forkjoincube.validators.IValidator;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class PolishParamsValidator implements IPolishParamsValidator
{
    private final IOperationsMap operationsMap;

    public PolishParamsValidator(IOperationsMap operationsMap)
    {
        this.operationsMap = operationsMap;
    }

    @Override
    public List<APISubError> validate(Tuple<String, List<Parameter>> object)
    {
        List<APISubError> errors = new ArrayList<>();
        String polish = object.left();
        List<Parameter> parameters = object.right();

        String[] elements = polish.split(" ");

        AtomicInteger willProvide = new AtomicInteger();
        AtomicInteger willConsume = new AtomicInteger();

        Arrays.stream(elements).forEach((String element) ->
        {
            IOperation operation = operationsMap.get(element);
            if (operation != null)
            {
                willConsume.addAndGet(operation.getNumberOfParams());
                willProvide.addAndGet(1);
                return;
            }
            List<Parameter> possibleParameters = parameters.stream().filter((Parameter parameter) -> Objects.equals(parameter.name(), element)).toList();
            if (possibleParameters.size() != 0)
            {
                willProvide.addAndGet(1);
                return;
            }
            try
            {
                Double constant = Double.parseDouble(element);
                willProvide.addAndGet(1);
            } catch (NumberFormatException e)
            {
                errors.add(new APISubError(String.format("Cannot understand symbol: '%s'", element), null));
            }
        });

        if (willProvide.get() - willConsume.get() != 1)
        {
            errors.add(new APISubError("Unmatching operators and operands"));
        }

        return errors.size() != 0 ? List.of(new APISubError("Polish and parameters are incompatible", errors)) : List.of();
    }
}
