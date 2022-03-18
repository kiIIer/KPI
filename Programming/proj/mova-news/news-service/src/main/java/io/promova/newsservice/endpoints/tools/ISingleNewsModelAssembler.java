package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.rep.NewsEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public interface ISingleNewsModelAssembler extends RepresentationModelAssembler<NewsEntity, EntityModel<NewsEntity>>
{
    @Override
    EntityModel<NewsEntity> toModel(NewsEntity newsEntity);
}
