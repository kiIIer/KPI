package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public class ZeroValidator implements IZeroValidator
{
    @Override
    public List<APISubError> validate(Double object)
    {
        if (object.equals(0))
        {
            return List.of(new APISubError("Value cannot be equal to zero"));
        }

        return List.of();
    }
}
