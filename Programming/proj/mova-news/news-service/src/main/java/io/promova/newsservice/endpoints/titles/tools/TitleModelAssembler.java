package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.endpoints.titles.TitlesController;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class TitleModelAssembler implements ITitleModelAssembler
{
    @Override
    public EntityModel<TitleEntity> toModel(TitleEntity title, boolean areLinksEnabled)
    {
        return areLinksEnabled
                ? EntityModel.of(
                title,
                linkTo(methodOn(TitlesController.class).one(title.getId(), "*/*")).withSelfRel(),
                linkTo(methodOn(TitlesController.class).all(null, null, null)).withRel("all")
        )
                : EntityModel.of(title);
    }
}
