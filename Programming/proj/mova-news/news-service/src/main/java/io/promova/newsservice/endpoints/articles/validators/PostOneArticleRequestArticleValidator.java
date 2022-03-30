package io.promova.newsservice.endpoints.articles.validators;

import io.promova.newsservice.endpoints.util.validators.INotNullValidator;
import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.IValidator;

import java.util.List;

public class PostOneArticleRequestArticleValidator implements IPostOneArticleRequestArticleValidator
{
    private final INotNullValidator notNullValidator;

    public PostOneArticleRequestArticleValidator(INotNullValidator notNullValidator)
    {
        this.notNullValidator = notNullValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> isNull = notNullValidator.validate(object);
        if (isNull.size() != 0)
        {
            return List.of(new APISubError("Article is invalid", isNull));
        }
        return List.of();
    }
}
