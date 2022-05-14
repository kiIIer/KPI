package io.promova.forkjoincube.validators.polish;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface IValidPolishValidator extends IValidator<String>
{
    @Override
    List<APISubError> validate(String object);
}
