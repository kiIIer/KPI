package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.models.logic.Parameter;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface IParamsValidator extends IValidator<List<Parameter>>
{
    @Override
    List<APISubError> validate(List<Parameter> object);
}
