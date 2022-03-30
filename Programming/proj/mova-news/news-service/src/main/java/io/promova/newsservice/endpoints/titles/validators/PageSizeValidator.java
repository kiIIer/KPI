package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.config.EnviromentalConfig;
import io.promova.newsservice.endpoints.util.APISubError;
import io.promova.newsservice.endpoints.util.validators.IValidator;

import java.util.ArrayList;
import java.util.List;

public class PageSizeValidator implements IPageSizeValidator
{
    private final EnviromentalConfig config;
    private final IValidator<String> isIntegerValidator;

    public PageSizeValidator(EnviromentalConfig config, IValidator<String> isIntegerValidator)
    {
        this.config = config;
        this.isIntegerValidator = isIntegerValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        List<APISubError> errors = new ArrayList<>();
        List<APISubError> subErrors = new ArrayList<>(isIntegerValidator.validate(object));
        if (subErrors.size() == 0)
        {
            int page = Integer.parseInt(object);
            if (page <= 0)
            {
                subErrors.add(new APISubError("Page must be greater than zero"));
            }
            if (page > config.getMaxPageSize())
            {
                subErrors.add(new APISubError(String.format("Page size must be less than maximum allowed of %d", config.getMaxPageSize())));
            }
        }
        return (subErrors.size() != 0)
                ? List.of(new APISubError("Field 'pageSize' is invalid", subErrors))
                : List.of();
    }
}