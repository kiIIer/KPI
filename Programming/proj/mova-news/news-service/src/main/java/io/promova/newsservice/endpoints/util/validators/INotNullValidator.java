package io.promova.newsservice.endpoints.util.validators;

import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.IValidator;

import java.util.List;

public interface INotNullValidator extends IValidator<Object>
{
    @Override
    List<APISubError> validate(Object object);
}
