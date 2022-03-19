package io.promova.newsservice.endpoints.entities;

import org.springframework.hateoas.EntityModel;

import java.util.List;

public class ResponseAllTitlesEntity
{
    private List<EntityModel<TitleEntity>> entityModels;

    public List<EntityModel<TitleEntity>> getEntityModels()
    {
        return entityModels;
    }

    public void setEntityModels(List<EntityModel<TitleEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }

    public ResponseAllTitlesEntity(List<EntityModel<TitleEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }

    public ResponseAllTitlesEntity()
    {
    }
}
