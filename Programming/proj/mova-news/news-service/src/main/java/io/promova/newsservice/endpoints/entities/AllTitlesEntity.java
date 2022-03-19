package io.promova.newsservice.endpoints.entities;

public class AllTitlesEntity
{
    private TitleEntity[] titleEntities;

    public TitleEntity[] getTitleEntities()
    {
        return titleEntities;
    }

    public void setTitleEntities(TitleEntity[] titleEntities)
    {
        this.titleEntities = titleEntities;
    }

    public AllTitlesEntity(TitleEntity[] titleEntities)
    {
        this.titleEntities = titleEntities;
    }

    public AllTitlesEntity()
    {
    }
}
