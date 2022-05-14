package io.promova.forkjoincube.validators.util;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface INotNullValidator extends IValidator
{
    @Override
    List<APISubError> validate(Object object);
}
