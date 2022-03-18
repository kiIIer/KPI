package io.promova.newsservice.endpoints.tools;

import io.promova.newsservice.endpoints.NewsController;
import io.promova.newsservice.rep.NewsEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class SingleNewsModelAssembler implements RepresentationModelAssembler<NewsEntity, EntityModel<NewsEntity>>
{
    @Override
    public EntityModel<NewsEntity> toModel(NewsEntity newsEntity)
    {

        return EntityModel.of(newsEntity,
                linkTo(methodOn(NewsController.class).getOne(newsEntity.getId())).withSelfRel(),
                linkTo(methodOn(NewsController.class).getAll()).withRel("news")
        );
    }
}
