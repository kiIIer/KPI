package io.promova.newsservice.endpoints.entities;

import io.promova.newsservice.rep.NewsEntity;

public class TitleEntity
{
    private String id;

    private String title;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public TitleEntity()
    {
    }

    public TitleEntity(String id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public TitleEntity(NewsEntity newsEntity)
    {
        this.id = newsEntity.getId();
        this.title = newsEntity.getTitle();
    }
}
