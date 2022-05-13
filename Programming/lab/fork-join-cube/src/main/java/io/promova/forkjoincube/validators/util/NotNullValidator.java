package io.promova.forkjoincube.validators.util;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public class NotNullValidator implements INotNullValidator
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
