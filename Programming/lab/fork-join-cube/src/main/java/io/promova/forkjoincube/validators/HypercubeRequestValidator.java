package io.promova.forkjoincube.validators;

import io.promova.forkjoincube.models.request.HypercubeRequest;
import io.promova.forkjoincube.util.APISubError;

import java.util.List;

public class HypercubeRequestValidator implements IValidator<HypercubeRequest>
{
    @Override
    public List<APISubError> validate(HypercubeRequest object)
    {
        return null;
    }
}
