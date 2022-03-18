package io.promova.newsservice.endpoints.entities;

import io.promova.newsservice.rep.NewsEntity;

public class HeaderEntity
{
    private String id;

    private String header;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public HeaderEntity()
    {
    }

    public HeaderEntity(String id, String header)
    {
        this.id = id;
        this.header = header;
    }

    public HeaderEntity(NewsEntity newsEntity)
    {
        this.id = newsEntity.getId();
        this.header = newsEntity.getHeader();
    }
}
