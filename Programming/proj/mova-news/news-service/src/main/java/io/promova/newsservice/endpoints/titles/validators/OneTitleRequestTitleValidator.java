package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.INotNullValidator;

import java.util.ArrayList;
import java.util.List;

public class OneTitleRequestTitleValidator implements IOneTitleRequestTitleValidator
{
    private final INotNullValidator notNullValidator;

    public OneTitleRequestTitleValidator(INotNullValidator notNullValidator)
    {
        this.notNullValidator = notNullValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> isNull = notNullValidator.validate(object);
        if (isNull.size() != 0)
        {
            return List.of(new APISubError("Title is invalid", isNull));
        }
        return new ArrayList<>();
    }
}
