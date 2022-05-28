package io.promova.multicube.tools.validators;

import io.promova.multicube.tools.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class PolishValidator implements IPolishValidator
{
    private final INullValidator nullValidator;
    private final IMatchingOperandsValidator matchingOperandsValidator;

    public PolishValidator(
            INullValidator nullValidator,
            IMatchingOperandsValidator matchingOperandsValidator
    )
    {
        this.nullValidator = nullValidator;
        this.matchingOperandsValidator = matchingOperandsValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> errors = new ArrayList<>(nullValidator.validate(object));

        if (errors.size() != 0)
        {
            return List.of(new APISubError("Polish is invalid", errors));
        }
        errors.addAll(matchingOperandsValidator.validate(object));

        return errors.size() != 0 ? List.of(new APISubError("Polish is invalid", errors)) : List.of();
    }
}
