package io.promova.forkjoincube.validators.util;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface IPositiveValidator extends IValidator<Double>
{
    @Override
    List<APISubError> validate(Double object);
}
