package io.promova.newsservice.endpoints.titles.entities;

import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public class PagedTitlesResponse
{
    List<EntityModel<TitleEntity>> entityModels;

    public List<EntityModel<TitleEntity>> getEntityModels()
    {
        return entityModels;
    }

    public void setEntityModels(List<EntityModel<TitleEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }

    public PagedTitlesResponse(List<EntityModel<TitleEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }

    public PagedTitlesResponse()
    {
    }
}
