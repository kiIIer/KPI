package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface INameValidator extends IValidator<String>
{
    @Override
    List<APISubError> validate(String object);
}
