package io.promova.newsservice.endpoints.titles.exceptions;

public class TitleEntityNotFoundException extends RuntimeException
{
    public TitleEntityNotFoundException(String id)
    {
        super("Couldn't find title with id: " + id);
    }
}
