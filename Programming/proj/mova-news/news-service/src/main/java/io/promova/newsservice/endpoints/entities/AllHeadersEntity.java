package io.promova.newsservice.endpoints.entities;

public class AllHeadersEntity
{
    private HeaderEntity[] headerEntities;

    public HeaderEntity[] getHeaderEntities()
    {
        return headerEntities;
    }

    public void setHeaderEntities(HeaderEntity[] headerEntities)
    {
        this.headerEntities = headerEntities;
    }

    public AllHeadersEntity(HeaderEntity[] headerEntities)
    {
        this.headerEntities = headerEntities;
    }

    public AllHeadersEntity()
    {
    }
}
