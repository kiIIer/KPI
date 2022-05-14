package io.promova.forkjoincube.validators.params;

import io.promova.forkjoincube.util.APISubError;
import io.promova.forkjoincube.validators.util.INotNullValidator;

import java.util.ArrayList;
import java.util.List;

public class NameValidator implements INameValidator
{
    private final INotNullValidator INotNullValidator;

    public NameValidator(INotNullValidator INotNullValidator)
    {
        this.INotNullValidator = INotNullValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> errors = new ArrayList<>(INotNullValidator.validate(object));
        return errors.size() != 0 ? List.of(new APISubError("Name is not valid", errors)) : List.of();
    }
}
