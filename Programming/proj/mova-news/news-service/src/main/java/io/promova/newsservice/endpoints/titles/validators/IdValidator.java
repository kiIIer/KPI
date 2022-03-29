package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;

public class IdValidator implements IIdValidator
{
    @Override
    public List<APISubError> validate(String object)
    {
        return List.of();
    }
}
