package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.entities.AllTitlesEntity;
import io.promova.newsservice.endpoints.entities.ResponseAllTitlesEntity;
import org.springframework.hateoas.EntityModel;

public interface IResponseAllTitlesEntityModelAssembler
{
    EntityModel<ResponseAllTitlesEntity> toModel(AllTitlesEntity entity, boolean addLinks);
}
