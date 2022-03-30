package io.promova.newsservice.endpoints.util.exceptions;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;

public class InvalidRequestException extends RuntimeException
{
    private List<APISubError> errors;

    public List<APISubError> getErrors()
    {
        return errors;
    }

    public void setErrors(List<APISubError> errors)
    {
        this.errors = errors;
    }

    public InvalidRequestException(String message, List<APISubError> errors)
    {
        super(message);
        this.errors = errors;
    }
}
