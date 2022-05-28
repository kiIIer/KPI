package io.promova.multicube.tools.util;

import java.util.List;

public class InvalidRequestException extends RuntimeException
{
    private final List<APISubError> errors;

    public List<APISubError> getErrors()
    {
        return errors;
    }

    public InvalidRequestException(List<APISubError> errors)
    {
        super("Request is invalid");
        this.errors = errors;
    }
}
