package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.util.INotNullValidator;
import io.promova.forkjoincube.validators.util.IPositiveValidator;

import java.util.ArrayList;
import java.util.List;

public class StepValidator implements IStepValidator
{
    private final INotNullValidator INotNullValidator;
    private final IPositiveValidator IPositiveValidator;

    public StepValidator(INotNullValidator INotNullValidator, IPositiveValidator IPositiveValidator)
    {
        this.INotNullValidator = INotNullValidator;
        this.IPositiveValidator = IPositiveValidator;
    }

    @Override
    public List<APISubError> validate(Double object)
    {
        List<APISubError> errors = new ArrayList<>(INotNullValidator.validate(object));

        if (errors.size() == 0)
        {
            errors.addAll(IPositiveValidator.validate(object));
        }

        return errors.size() != 0 ? List.of(new APISubError("Step is invalid", errors)) : List.of();
    }
}
