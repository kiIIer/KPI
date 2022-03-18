package io.promova.newsservice.singlenew.exceptions;

public class SingleNewsNotFoundException extends RuntimeException
{
    public SingleNewsNotFoundException(Long id)
    {
        super("Couldn't find formula with id: " + id);
    }

}
