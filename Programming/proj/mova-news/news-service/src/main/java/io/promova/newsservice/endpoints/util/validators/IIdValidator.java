package io.promova.newsservice.endpoints.util.validators;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;

public interface IIdValidator extends IValidator<String>
{
    @Override
    List<APISubError> validate(String object);
}
