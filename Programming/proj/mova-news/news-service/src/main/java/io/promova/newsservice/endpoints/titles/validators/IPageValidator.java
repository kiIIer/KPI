package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.IValidator;

import java.util.List;

public interface IPageValidator extends IValidator<String>
{
    @Override
    List<APISubError> validate(String object);
}
