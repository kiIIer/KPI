package io.promova.multicube.tools.validators;

import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class BoundsValidator implements IBoundsValidator
{
    @Override
    public List<APISubError> validate(Parameter object)
    {
        if (!(object.getLowBound() < object.getHighBound()))
        {
            return List.of((new APISubError("Lower bound must me lower than Higher bound")));
        }

        return List.of();
    }
}
