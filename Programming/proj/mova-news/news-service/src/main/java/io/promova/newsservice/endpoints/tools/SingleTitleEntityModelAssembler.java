package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.TitleController;
import io.promova.newsservice.endpoints.NewsController;
import io.promova.newsservice.endpoints.entities.TitleEntity;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class SingleTitleEntityModelAssembler implements ISingleTitleEntityModelAssembler
{
    @Override
    public EntityModel<TitleEntity> toModel(TitleEntity entity, boolean addLinks)
    {
//        return EntityModel.of(
//                entity,
//                linkTo(methodOn(TitleController.class).getOne(entity.getId())).withSelfRel(),
//                linkTo(methodOn(NewsController.class).getOne(entity.getId())).withRel("full")
//        );
        return (addLinks) ? EntityModel.of(
                entity,
                linkTo(methodOn(TitleController.class).getOne(entity.getId(), "*/*")).withSelfRel(),
                linkTo(methodOn(NewsController.class).getOne(entity.getId(), "*/*")).withRel("full")
        ) : EntityModel.of(
                entity
        );
    }
}
