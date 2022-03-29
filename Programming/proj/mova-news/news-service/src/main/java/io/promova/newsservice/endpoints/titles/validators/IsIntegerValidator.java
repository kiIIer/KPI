package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;

public class IsIntegerValidator implements IIsIntegerValidator
{
    @Override
    public List<APISubError> validate(String object)
    {
        try
        {
            Integer.valueOf(object);
        } catch (NumberFormatException exception)
        {
            return List.of(new APISubError("One or more parameters are not numbers", null));
        }

        return List.of();
    }
}
