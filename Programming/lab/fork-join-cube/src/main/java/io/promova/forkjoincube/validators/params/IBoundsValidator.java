package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.util.Tuple;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface IBoundsValidator extends IValidator<Tuple<Double, Double>>
{
    @Override
    List<APISubError> validate(Tuple<Double, Double> object);
}
