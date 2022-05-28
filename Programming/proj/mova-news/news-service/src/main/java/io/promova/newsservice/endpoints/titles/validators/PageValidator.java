package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.IValidator;

import java.util.ArrayList;
import java.util.List;

public class PageValidator implements IPageValidator
{

    private final IValidator<String> isIntegerValidator;

    public PageValidator(IValidator<String> isIntegerValidator)
    {
        this.isIntegerValidator = isIntegerValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> subErrors = new ArrayList<>(isIntegerValidator.validate(object));
        if (subErrors.size() == 0)
        {
            int page = Integer.parseInt(object);
            if (page < 0)
            {
                subErrors.add(new APISubError("Cannot be less than zero", null));
            }
        }
        return (subErrors.size() != 0)
                ? List.of(new APISubError("Parameter 'page' is invalid", subErrors))
                : List.of();

    }
}
