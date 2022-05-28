package io.promova.multicube.tools.validators;

import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public interface IBoundsValidator extends IValidator<Parameter>
{
    @Override
    List<APISubError> validate(Parameter object);
}
