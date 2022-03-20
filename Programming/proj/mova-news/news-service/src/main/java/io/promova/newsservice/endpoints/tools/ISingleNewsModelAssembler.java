package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.rep.NewsEntity;
import org.springframework.hateoas.EntityModel;

public interface ISingleNewsModelAssembler
{
    EntityModel<NewsEntity> toModel(NewsEntity newsEntity, boolean addLinks);
}
