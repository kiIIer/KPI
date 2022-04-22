package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public interface IStepValidator extends IValidator<Double>
{
    @Override
    List<APISubError> validate(Double object);
}
