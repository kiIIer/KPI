package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.util.INotNullValidator;

import java.util.ArrayList;
import java.util.List;

public class LowBoundValidator implements ILowBoundValidator
{
    private final INotNullValidator INotNullValidator;

    public LowBoundValidator(INotNullValidator INotNullValidator)
    {
        this.INotNullValidator = INotNullValidator;
    }

    @Override
    public List<APISubError> validate(Double object)
    {
        List<APISubError> errors = new ArrayList<>(INotNullValidator.validate(object));
        return errors.size() != 0 ? List.of(new APISubError("Low Bound is not Valid", errors)) : List.of();
    }
}
