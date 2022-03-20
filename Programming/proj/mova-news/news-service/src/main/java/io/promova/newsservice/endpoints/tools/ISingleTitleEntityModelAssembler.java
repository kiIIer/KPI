package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.TitleEntity;
import org.springframework.hateoas.EntityModel;

public interface ISingleTitleEntityModelAssembler
{
    EntityModel<TitleEntity> toModel(TitleEntity entity, boolean addLinks);
}
