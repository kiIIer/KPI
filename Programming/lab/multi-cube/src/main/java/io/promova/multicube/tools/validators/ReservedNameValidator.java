package io.promova.multicube.tools.validators;

import io.promova.multicube.calculators.OperationsMap;
import io.promova.multicube.calculators.operation.IOperation;
import io.promova.multicube.tools.util.APISubError;

import java.util.List;
import java.util.Map;

public class ReservedNameValidator implements IReservedNameValidator
{
    private final OperationsMap map;

    public ReservedNameValidator(OperationsMap map)
    {
        this.map = map;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        for (String reserved : map.keySet())
        {
            if (object.equals(reserved))
            {
                return List.of(new APISubError("This name is reserved"));
            }
        }
        return List.of();
    }
}
