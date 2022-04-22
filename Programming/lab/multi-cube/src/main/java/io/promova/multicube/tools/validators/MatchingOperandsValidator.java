package io.promova.multicube.tools.validators;

import io.promova.multicube.calculators.OperationsMap;
import io.promova.multicube.calculators.operation.IOperation;
import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchingOperandsValidator implements IMatchingOperandsValidator
{
    private final OperationsMap map;

    public MatchingOperandsValidator(
            OperationsMap map
    )
    {
        this.map = map;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        int counter = 0;
        String[] elements = object.split(" ");
        for (String element : elements)
        {
            IOperation operation = map.get(element);
            counter += operation == null ? -1 : operation.getNumberOfParams();
        }

        return counter != 0 ? List.of(new APISubError("Unmatching operators and operands")) : List.of();
    }
}
