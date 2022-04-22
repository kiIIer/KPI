package io.promova.multicube.tools.validators;

import io.promova.multicube.models.HypercubeRequest;
import io.promova.multicube.tools.util.APISubError;

import java.util.List;

public interface IHypercubeRequestValidator extends IValidator<HypercubeRequest>
{
    @Override
    List<APISubError> validate(HypercubeRequest object);
}
