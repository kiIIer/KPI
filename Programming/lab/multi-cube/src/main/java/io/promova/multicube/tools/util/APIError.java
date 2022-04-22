package io.promova.multicube.tools.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class APIError
{
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<APISubError> subErrors;

    public HttpStatus getStatus()
    {
        return status;
    }

    public void setStatus(HttpStatus status)
    {
        this.status = status;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getDebugMessage()
    {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage)
    {
        this.debugMessage = debugMessage;
    }

    public List<APISubError> getSubErrors()
    {
        return subErrors;
    }

    public void setSubErrors(List<APISubError> subErrors)
    {
        this.subErrors = subErrors;
    }

    private APIError()
    {
        timestamp = LocalDateTime.now();
    }

    public APIError(HttpStatus status)
    {
        this();
        this.status = status;
    }

    public APIError(HttpStatus status, Throwable ex)
    {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getMessage();
    }

    public APIError(HttpStatus status, String message, Throwable ex)
    {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getMessage();
    }

    public APIError(HttpStatus status, String message, Throwable ex, List<APISubError> errors)
    {
        this(status, message, ex);
        this.subErrors = errors;
    }
}
