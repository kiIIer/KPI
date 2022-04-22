package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public interface INameValidator extends IValidator<String>
{
    @Override
    List<APISubError> validate(String object);
}
