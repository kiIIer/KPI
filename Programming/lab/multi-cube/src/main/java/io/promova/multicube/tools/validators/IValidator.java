package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public interface IValidator<V>
{
    List<APISubError> validate(V object);
}
