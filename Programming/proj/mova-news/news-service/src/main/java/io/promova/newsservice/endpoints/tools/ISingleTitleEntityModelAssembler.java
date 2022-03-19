package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.TitleEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public interface ISingleTitleEntityModelAssembler extends RepresentationModelAssembler<TitleEntity, EntityModel<TitleEntity>>
{
    @Override
    EntityModel<TitleEntity> toModel(TitleEntity entity);
}
