package io.promova.newsservice.endpoints.util.exceptions;

import io.promova.newsservice.endpoints.util.APISubError;

import java.util.List;

public class EntityNotFoundException extends RuntimeException
{
    private final List<APISubError> errors;

    public List<APISubError> getErrors()
    {
        return errors;
    }

    public EntityNotFoundException(String id, List<APISubError> errors)
    {
        super("Couldn't find entity with id: " + id);
        this.errors = errors;
    }

    public EntityNotFoundException(String id)
    {
        this(id, null);
    }
}
