package io.promova.newsservice.endpoints.titles.entities;

import jakarta.validation.constraints.NotNull;

public class PostOneTitleRequest
{
    private String title;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public PostOneTitleRequest(String title)
    {
        this.title = title;
    }

    public PostOneTitleRequest()
    {
    }
}
