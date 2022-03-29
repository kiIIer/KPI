package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.endpoints.titles.tools.util.TitlesAllGetRequest;
import io.promova.newsservice.endpoints.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class TitlesAllGetRequestValidator implements IValidator<TitlesAllGetRequest>
{
    private final IValidator<String> pageSizeValidator;
    private final IValidator<String> pageValidator;

    public TitlesAllGetRequestValidator(IPageSizeValidator pageSizeValidator, IPageValidator pageValidator)
    {
        this.pageSizeValidator = pageSizeValidator;
        this.pageValidator = pageValidator;
    }

    @Override
    public List<APISubError> validate(TitlesAllGetRequest object)
    {
        ArrayList<APISubError> errors = new ArrayList<>();

        errors.addAll(pageSizeValidator.validate(object.getPageSize()));
        errors.addAll(pageValidator.validate(object.getPage()));

        return errors;

    }
}
