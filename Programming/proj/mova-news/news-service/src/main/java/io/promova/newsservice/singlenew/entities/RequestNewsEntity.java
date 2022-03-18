package io.promova.newsservice.singlenew.entities;

import jakarta.validation.constraints.NotNull;

public class RequestNewsEntity
{
    @NotNull
    private String header;

    @NotNull
    private String body;

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public RequestNewsEntity()
    {
    }

    public RequestNewsEntity(String header, String body)
    {
        this.header = header;
        this.body = body;
    }
}
