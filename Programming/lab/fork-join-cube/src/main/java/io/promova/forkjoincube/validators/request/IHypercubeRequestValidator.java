package io.promova.forkjoincube.validators.request;

import io.promova.forkjoincube.models.request.HypercubeRequest;
import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.IValidator;

import java.util.List;

public interface IHypercubeRequestValidator extends IValidator<HypercubeRequest>
{
    @Override
    List<APISubError> validate(HypercubeRequest object);
}
