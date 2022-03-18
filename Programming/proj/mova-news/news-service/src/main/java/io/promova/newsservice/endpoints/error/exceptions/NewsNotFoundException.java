package io.promova.newsservice.endpoints.error.exceptions;

public class NewsNotFoundException extends RuntimeException
{
    public NewsNotFoundException(String id)
    {
        super("Couldn't find formula with id: " + id);
    }

}
