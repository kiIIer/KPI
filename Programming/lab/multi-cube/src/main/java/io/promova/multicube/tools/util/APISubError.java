package io.promova.multicube.tools.util;

import java.util.List;

public class APISubError
{
    private String message;
    private List<APISubError> subErrors;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public List<APISubError> getSubErrors()
    {
        return subErrors;
    }

    public void setSubErrors(List<APISubError> subErrors)
    {
        this.subErrors = subErrors;
    }

    public APISubError(String message, List<APISubError> subErrors)
    {
        this.message = message;
        this.subErrors = subErrors;
    }

    public APISubError(String message)
    {
        this.message = message;
    }
}
