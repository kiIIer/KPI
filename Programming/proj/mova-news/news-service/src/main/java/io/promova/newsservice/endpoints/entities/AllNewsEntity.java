package io.promova.newsservice.endpoints.entities;

import io.promova.newsservice.rep.NewsEntity;

public class AllNewsEntity
{
    private NewsEntity[] newsEntities;

    public NewsEntity[] getNewsEntities()
    {
        return newsEntities;
    }

    public void setNewsEntities(NewsEntity[] newsEntities)
    {
        this.newsEntities = newsEntities;
    }

    public AllNewsEntity()
    {
    }

    public AllNewsEntity(NewsEntity[] newsEntities)
    {
        this.newsEntities = newsEntities;
    }
}
