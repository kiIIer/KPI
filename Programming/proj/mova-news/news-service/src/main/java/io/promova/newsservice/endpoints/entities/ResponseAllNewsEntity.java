package io.promova.newsservice.endpoints.entities;

import io.promova.newsservice.rep.NewsEntity;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public class ResponseAllNewsEntity
{
    private List<EntityModel<NewsEntity>> entityModels;

    public List<EntityModel<NewsEntity>> getEntityModels()
    {
        return entityModels;
    }

    public void setEntityModels(List<EntityModel<NewsEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }

    public ResponseAllNewsEntity()
    {
    }

    public ResponseAllNewsEntity(List<EntityModel<NewsEntity>> entityModels)
    {
        this.entityModels = entityModels;
    }
}
