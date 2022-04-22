package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public interface INullValidator extends IValidator<Object>
{
    @Override
    List<APISubError> validate(Object object);
}
