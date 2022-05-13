package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface IStepValidator extends IValidator<Double>
{
    @Override
    List<APISubError> validate(Double object);
}
