package io.promova.forkjoincube.validators;

import io.promova.forkjoincube.util.APISubError;

import java.util.List;

public class NotNullValidator implements IValidator
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
