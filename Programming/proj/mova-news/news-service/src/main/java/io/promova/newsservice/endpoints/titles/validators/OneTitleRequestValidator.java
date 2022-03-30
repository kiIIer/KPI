package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.titles.entities.PostOneTitleRequest;
import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.INotNullValidator;

import java.util.ArrayList;
import java.util.List;

public class OneTitleRequestValidator implements IOneTitleRequestValidator
{
    private final INotNullValidator notNullValidator;
    private final IOneTitleRequestTitleValidator postOneTitleRequestTitleValidator;

    public OneTitleRequestValidator(INotNullValidator notNullValidator,
                                    IOneTitleRequestTitleValidator postOneTitleRequestTitleValidator)
    {
        this.notNullValidator = notNullValidator;
        this.postOneTitleRequestTitleValidator = postOneTitleRequestTitleValidator;
    }

    @Override
    public List<APISubError> validate(PostOneTitleRequest object)
    {
        List<APISubError> subErrors = new ArrayList<>(notNullValidator.validate(object));
        if (subErrors.size() == 0)
        {
            subErrors.addAll(postOneTitleRequestTitleValidator.validate(object.getTitle()));
        }
        return (subErrors.size() != 0)
                ? List.of(new APISubError("Body is invalid!", subErrors))
                : List.of();
    }
}
