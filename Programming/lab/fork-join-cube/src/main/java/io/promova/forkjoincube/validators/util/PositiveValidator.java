package io.promova.forkjoincube.validators.util;

import io.promova.forkjoincube.util.APISubError;

import java.util.List;

public class PositiveValidator implements IPositiveValidator
{
    @Override
    public List<APISubError> validate(Double object)
    {
        return object > 0 ? List.of() : List.of(new APISubError("Value must be greater than zero"));
    }
}
