package io.promova.newsservice.endpoints.util.validators;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;

public class NotNullValidator implements INotNullValidator
{
    @Override
    public List<APISubError> validate(Object object)
    {
        return object == null ? List.of(new APISubError("Value is null!", null)) : List.of();
    }
}
