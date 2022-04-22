package io.promova.multicube.tools.validators;

import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class ParameterValidator implements IParameterValidator
{
    private final INullValidator nullValidator;
    private final IBoundsValidator boundsValidator;
    private final INameValidator nameValidator;
    private final IStepValidator stepValidator;

    public ParameterValidator(
            INullValidator nullValidator,
            IBoundsValidator boundsValidator,
            INameValidator nameValidator,
            IStepValidator stepValidator
    )
    {
        this.nullValidator = nullValidator;
        this.boundsValidator = boundsValidator;
        this.nameValidator = nameValidator;
        this.stepValidator = stepValidator;
    }

    @Override
    public List<APISubError> validate(Parameter object)
    {
        List<APISubError> errors = new ArrayList<>(nullValidator.validate(object));

        if (errors.size() != 0)
        {
            return List.of(new APISubError("Parameter is invalid", errors));
        }
        errors.addAll(boundsValidator.validate(object));
        errors.addAll(nameValidator.validate(object.getName()));
        errors.addAll(stepValidator.validate(object.getStep()));

        return errors.size() != 0 ? List.of(new APISubError("Parameter '" + object.getName() + "' is invalid", errors)) : List.of();
    }
}
