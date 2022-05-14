package io.promova.forkjoincube.validators;

import io.promova.forkjoincube.util.APISubError;

import java.util.List;

public interface IValidator<V>
{
    List<APISubError> validate(V object);
}
