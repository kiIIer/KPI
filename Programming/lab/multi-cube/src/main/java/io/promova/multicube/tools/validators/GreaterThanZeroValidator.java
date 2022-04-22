package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public class GreaterThanZeroValidator implements IGreaterThanZeroValidator
{
    @Override
    public List<APISubError> validate(Double object)
    {
        if (!(object.compareTo(0.0) < 0))
        {
            return List.of(new APISubError("Value is less than zero"));
        }
        return List.of();
    }
}
