package io.promova.multicube.tools.validators;

import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public interface IParametersValidator extends IValidator<List<Parameter>>
{
    @Override
    List<APISubError> validate(List<Parameter> object);
}
