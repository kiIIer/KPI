package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.HeaderController;
import io.promova.newsservice.endpoints.NewsController;
import io.promova.newsservice.endpoints.entities.HeaderEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class SingleHeaderEntityModelAssembler implements ISingleHeaderEntityModelAssembler
{
    @Override
    public EntityModel<HeaderEntity> toModel(HeaderEntity entity)
    {
        return EntityModel.of(
                entity,
                linkTo(methodOn(HeaderController.class).getOne(entity.getId())).withSelfRel(),
                linkTo(methodOn(NewsController.class).getOne(entity.getId())).withRel("full"),
                linkTo(methodOn(HeaderController.class).getAll()).withRel("headers")
        );
    }
}
