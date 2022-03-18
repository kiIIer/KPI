package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.HeaderEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public interface ISingleHeaderEntityModelAssembler extends RepresentationModelAssembler<HeaderEntity, EntityModel<HeaderEntity>>
{
    @Override
    EntityModel<HeaderEntity> toModel(HeaderEntity entity);
}
