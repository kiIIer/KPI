package io.promova.newsservice.endpoints.titles.validators;

import io.promova.newsservice.config.EnvConfig;
import io.promova.newsservice.endpoints.util.APISubError;

import java.util.ArrayList;
import java.util.List;

public class PageSizeValidator implements IPageSizeValidator
{
    private final EnvConfig config;
    private final IValidator<String> isIntegerValidator;

    public PageSizeValidator(EnvConfig config, IValidator<String> isIntegerValidator)
    {
        this.config = config;
        this.isIntegerValidator = isIntegerValidator;
    }

    @Override
    public List<APISubError> validate(String object)
    {
        ArrayList<APISubError> apiSubErrors = new ArrayList<>(isIntegerValidator.validate(object));
        if (apiSubErrors.size() != 0)
        {
            return apiSubErrors;
        }
        int page = Integer.parseInt(object);
        if (page <= 0)
        {
            apiSubErrors.add(new APISubError("Page must be greater than zero", null));
        }
        if (page > config.getMaxPageSize())
        {
            apiSubErrors.add(new APISubError(String.format("Page size must be less than maximum allowed of %d", config.getMaxPageSize()), null));
        }
        return apiSubErrors;
    }
}
