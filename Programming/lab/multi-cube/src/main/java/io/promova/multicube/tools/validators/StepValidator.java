package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class StepValidator implements IStepValidator
{

    private final INullValidator nullValidator;
    private final IZeroValidator zeroValidator;

    public StepValidator(
            INullValidator nullValidator,
            IZeroValidator zeroValidator
    )
    {
        this.nullValidator = nullValidator;
        this.zeroValidator = zeroValidator;
    }

    @Override
    public List<APISubError> validate(Double object)
    {
        List<APISubError> errors = new ArrayList<>(nullValidator.validate(object));

        if (errors.size() != 0)
        {
            return List.of(new APISubError("Step is invalid", errors));
        }

        errors.addAll(zeroValidator.validate(object));

        return errors.size() != 0 ? List.of(new APISubError("Step is invalid", errors)) : List.of();
    }
}
