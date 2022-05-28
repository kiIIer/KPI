package io.promova.newsservice.endpoints.articles.tools;

import io.promova.newsservice.reps.ArticleEntity;
import org.springframework.hateoas.EntityModel;

public interface IArticleModelAssembler
{
    EntityModel<ArticleEntity> toModel(
            ArticleEntity article,
            boolean areLinksEnabled
    );
}
