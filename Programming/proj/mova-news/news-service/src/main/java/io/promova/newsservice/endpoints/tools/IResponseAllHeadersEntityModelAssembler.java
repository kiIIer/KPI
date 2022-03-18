package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.AllHeadersEntity;
import io.promova.newsservice.endpoints.entities.ResponseAllHeadersEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public interface IResponseAllHeadersEntityModelAssembler extends RepresentationModelAssembler<AllHeadersEntity, EntityModel<ResponseAllHeadersEntity>>
{
    @Override
    EntityModel<ResponseAllHeadersEntity> toModel(AllHeadersEntity entity);
}
