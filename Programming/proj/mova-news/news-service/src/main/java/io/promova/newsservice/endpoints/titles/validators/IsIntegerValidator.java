package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.ArrayList;
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
            return List.of(new APISubError("Value is not a number", null));
        }

        return new ArrayList<>();
    }
}
