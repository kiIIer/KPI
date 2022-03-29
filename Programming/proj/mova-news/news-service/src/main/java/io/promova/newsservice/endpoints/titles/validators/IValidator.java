package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;

public interface IValidator<T>
{
    public List<APISubError> validate(T object);
}
