package io.promova.multicube.tools.validators;

import io.promova.multicube.models.HypercubeRequest;
import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class HypercubeRequestValidator implements IHypercubeRequestValidator
{
    private final INullValidator nullValidator;
    private final IParametersValidator parametersValidator;
    private final IHaveAllDataValidator haveAllDataValidator;
    private final IPolishValidator polishValidator;

    public HypercubeRequestValidator(
            INullValidator nullValidator,
            IParametersValidator parametersValidator,
            IHaveAllDataValidator haveAllDataValidator,
            IPolishValidator polishValidator
    )
    {
        this.nullValidator = nullValidator;
        this.parametersValidator = parametersValidator;
        this.haveAllDataValidator = haveAllDataValidator;
        this.polishValidator = polishValidator;
    }

    @Override
    public List<APISubError> validate(HypercubeRequest object)
    {
        List<APISubError> errors = new ArrayList<>(nullValidator.validate(object));

        if (errors.size() != 0)
        {
            return List.of(new APISubError("Request is invalid", errors));
        }
        errors.addAll(parametersValidator.validate(object.getParameters()));
        errors.addAll(polishValidator.validate(object.getPolish()));
        if (errors.size() != 0)
        {
            return List.of(new APISubError("Request is invalid", errors));
        }
        errors.addAll(haveAllDataValidator.validate(object));

        return errors.size() != 0 ? List.of(new APISubError("Request is invalid", errors)) : List.of();
    }
}
