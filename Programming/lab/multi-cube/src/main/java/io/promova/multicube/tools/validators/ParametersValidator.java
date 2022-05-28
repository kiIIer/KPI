package io.promova.multicube.tools.validators;

import io.promova.multicube.models.Parameter;
import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParametersValidator implements IParametersValidator
{
    private final INullValidator nullValidator;
    private final IParameterValidator parameterValidator;

    public ParametersValidator(
            INullValidator nullValidator,
            IParameterValidator parameterValidator
    )
    {
        this.nullValidator = nullValidator;
        this.parameterValidator = parameterValidator;
    }

    @Override
    public List<APISubError> validate(List<Parameter> object)
    {
        List<APISubError> errors = new ArrayList<>(nullValidator.validate(object));

        if (errors.size() != 0)
        {
            return List.of(new APISubError("Parameters are invalid", errors));
        }
        Arrays.stream(object.toArray(new Parameter[0])).forEach(parameter ->
        {
            errors.addAll(parameterValidator.validate(parameter));
        });

        return errors.size() != 0 ? List.of(new APISubError("Parameters are invalid", errors)) : List.of();
    }
}
