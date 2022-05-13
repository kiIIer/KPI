package io.promova.forkjoincube.validators.polish;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.util.INotNullValidator;

import java.util.ArrayList;
import java.util.List;

public class PolishValidator implements IPolishValidator
{
    private final INotNullValidator INotNullValidator;

    public PolishValidator(INotNullValidator INotNullValidator)
    {
        this.INotNullValidator = INotNullValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> errors = new ArrayList<>(INotNullValidator.validate(object));


        return errors.size() != 0 ? List.of(new APISubError("Polish is invalid", errors)) : List.of();
    }
}
