package io.promova.newsservice.endpoints.entities;

import jakarta.validation.constraints.NotNull;

public class RequestNewsEntity
{
    @NotNull
    private String title;

    @NotNull
    private String article;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArticle()
    {
        return article;
    }

    public void setArticle(String article)
    {
        this.article = article;
    }

    public RequestNewsEntity()
    {
    }

    public RequestNewsEntity(String title, String article)
    {
        this.title = title;
        this.article = article;
    }
}
