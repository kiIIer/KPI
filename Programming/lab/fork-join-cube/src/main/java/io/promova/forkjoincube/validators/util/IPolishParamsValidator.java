package io.promova.forkjoincube.validators.util;

import io.promova.forkjoincube.models.logic.Parameter;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.util.Tuple;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface IPolishParamsValidator extends IValidator<Tuple<String, List<Parameter>>>
{
    @Override
    List<APISubError> validate(Tuple<String, List<Parameter>> object);
}
