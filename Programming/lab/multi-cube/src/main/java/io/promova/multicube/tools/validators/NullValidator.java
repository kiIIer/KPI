package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public class NullValidator implements INullValidator
{

    @Override
    public List<APISubError> validate(Object object)
    {
        if (object == null)
        {
            return List.of(new APISubError("Value cannot be null", null));
        }
        return List.of();
    }
}
