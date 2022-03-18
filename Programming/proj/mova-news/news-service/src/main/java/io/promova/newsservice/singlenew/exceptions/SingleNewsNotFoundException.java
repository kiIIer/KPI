package io.promova.newsservice.singlenew.exceptions;

public class SingleNewsNotFoundException extends RuntimeException
{
    public SingleNewsNotFoundException(String id)
    {
        super("Couldn't find formula with id: " + id);
    }

}
