package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.titles.entities.PostOneTitleRequest;
import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.IValidator;

import java.util.List;

public interface IOneTitleRequestValidator extends IValidator<PostOneTitleRequest>
{
    @Override
    List<APISubError> validate(PostOneTitleRequest object);
}
