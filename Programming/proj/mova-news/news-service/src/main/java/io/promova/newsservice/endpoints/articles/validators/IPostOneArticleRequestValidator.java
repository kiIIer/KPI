package io.promova.newsservice.endpoints.articles.validators;

import io.promova.newsservice.endpoints.articles.entities.OneArticleRequest;
import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.IValidator;

import java.util.List;

public interface IPostOneArticleRequestValidator extends IValidator<OneArticleRequest>
{
    @Override
    List<APISubError> validate(OneArticleRequest object);
}
