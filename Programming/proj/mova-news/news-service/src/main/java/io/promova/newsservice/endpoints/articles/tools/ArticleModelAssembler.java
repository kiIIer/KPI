package io.promova.newsservice.endpoints.articles.tools;

import io.promova.newsservice.endpoints.articles.ArticlesController;
import io.promova.newsservice.endpoints.titles.TitlesController;
import io.promova.newsservice.reps.ArticleEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;

import java.awt.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class ArticleModelAssembler implements IArticleModelAssembler
{
    @Override
    public EntityModel<ArticleEntity> toModel(
            ArticleEntity article,
            boolean areLinksEnabled
    )
    {
        return areLinksEnabled
                ? EntityModel.of(
                article,
                linkTo(methodOn(ArticlesController.class).one(article.getId(), MediaType.ALL_VALUE)).withSelfRel(),
                linkTo(methodOn(TitlesController.class).one(article.getId(), MediaType.ALL_VALUE)).withRel("title")
        )
                : EntityModel.of(article);
    }
}
