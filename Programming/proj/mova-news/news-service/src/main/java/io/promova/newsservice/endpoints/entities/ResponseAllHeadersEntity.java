package io.promova.newsservice.endpoints.entities;

import org.springframework.hateoas.EntityModel;

import java.util.List;

public class ResponseAllHeadersEntity
{
    private List<EntityModel<HeaderEntity>> entityModels;

    public List<EntityModel<HeaderEntity>> getEntityModels()
    {
        return entityModels;
    }

    public void setEntityModels(List<EntityModel<HeaderEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }

    public ResponseAllHeadersEntity(List<EntityModel<HeaderEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }

    public ResponseAllHeadersEntity()
    {
    }
}
