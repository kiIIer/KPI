package io.promova.newsservice.endpoints.util.validators;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdValidator implements IIdValidator
{
    @Override
    public List<APISubError> validate(String object)
    {
        Pattern wordPattern = Pattern.compile("^\\w{10}$");

        Matcher matcher = wordPattern.matcher(object);

        if (matcher.results().count() != 1)
        {
            return List.of(new APISubError("Id structure is unexpected", null));
        }
        return List.of();
    }
}
