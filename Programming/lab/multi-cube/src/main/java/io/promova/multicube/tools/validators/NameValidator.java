package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class NameValidator implements INameValidator
{

    private final INullValidator nullValidator;
    private final IReservedNameValidator reservedNameValidator;

    public NameValidator(
            INullValidator nullValidator,
            IReservedNameValidator reservedNameValidator
    )
    {
        this.nullValidator = nullValidator;
        this.reservedNameValidator = reservedNameValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> errors = new ArrayList<>(nullValidator.validate(object));

        if (errors.size() != 0)
        {
            return List.of(new APISubError("Name is invalid", errors));
        }

        errors.addAll(reservedNameValidator.validate(object));

        return errors.size() != 0 ? List.of(new APISubError("Name is invalid", errors)) : List.of();
    }
}
