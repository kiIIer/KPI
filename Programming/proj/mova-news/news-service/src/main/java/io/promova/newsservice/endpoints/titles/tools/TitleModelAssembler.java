package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.endpoints.articles.ArticlesController;
import io.promova.newsservice.endpoints.titles.TitlesController;
import io.promova.newsservice.reps.TitleEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class TitleModelAssembler implements ITitleModelAssembler
{
    @Override
    public EntityModel<TitleEntity> toModel(
            TitleEntity title,
            boolean areLinksEnabled,
            Integer pageSize
    )
    {
        return areLinksEnabled
                ? EntityModel.of(
                title,
                linkTo(methodOn(TitlesController.class).one(title.getId(), MediaType.ALL_VALUE)).withSelfRel(),
                linkTo(methodOn(TitlesController.class).all("0", String.valueOf(pageSize), "", MediaType.ALL_VALUE)).withRel("all"),
                linkTo(methodOn(ArticlesController.class).one(title.getId(), MediaType.ALL_VALUE)).withRel("article")
        )
                : EntityModel.of(title);
    }
}
