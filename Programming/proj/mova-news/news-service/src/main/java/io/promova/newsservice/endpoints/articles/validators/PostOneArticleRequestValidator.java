package io.promova.newsservice.endpoints.articles.validators;

import io.promova.newsservice.endpoints.articles.entities.OneArticleRequest;
import io.promova.newsservice.endpoints.util.validators.INotNullValidator;
import io.promova.newsservice.endpoints.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class PostOneArticleRequestValidator implements IPostOneArticleRequestValidator
{
    private final INotNullValidator notNullValidator;
    private final IPostOneArticleRequestArticleValidator postOneArticleRequestArticleValidator;

    public PostOneArticleRequestValidator(
            INotNullValidator notNullValidator,
            IPostOneArticleRequestArticleValidator postOneArticleRequestArticleValidator
    )
    {
        this.notNullValidator = notNullValidator;
        this.postOneArticleRequestArticleValidator = postOneArticleRequestArticleValidator;
    }

    @Override
    public List<APISubError> validate(OneArticleRequest object)
    {
        List<APISubError> subErrors = new ArrayList<>(notNullValidator.validate(object));
        if (subErrors.size() == 0)
        {
            subErrors.addAll(postOneArticleRequestArticleValidator.validate(object.getArticle()));
        }
        return (subErrors.size() != 0)
                ? List.of(new APISubError("Body is invalid!", subErrors))
                : List.of();
    }
}
