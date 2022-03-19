package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.AllTitlesEntity;
import io.promova.newsservice.endpoints.entities.ResponseAllTitlesEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public interface IResponseAllTitlesEntityModelAssembler extends RepresentationModelAssembler<AllTitlesEntity, EntityModel<ResponseAllTitlesEntity>>
{
    @Override
    EntityModel<ResponseAllTitlesEntity> toModel(AllTitlesEntity entity);
}
