package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;

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
        ArrayList<APISubError> apiSubErrors = new ArrayList<>(isIntegerValidator.validate(object));
        if (apiSubErrors.size() != 0)
        {
            return apiSubErrors;
        }
        int page = Integer.parseInt(object);
        if (page < 0)
        {
            apiSubErrors.add(new APISubError("Page number cannot be less than zero", null));
        }

        return apiSubErrors;
    }
}
