package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.AllNewsEntity;
import io.promova.newsservice.endpoints.entities.ResponseAllNewsEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public interface IResponseAllNewsEntityModelAssembler extends RepresentationModelAssembler<AllNewsEntity, EntityModel<ResponseAllNewsEntity>>
{
    @Override
    EntityModel<ResponseAllNewsEntity> toModel(AllNewsEntity allNews);
}
