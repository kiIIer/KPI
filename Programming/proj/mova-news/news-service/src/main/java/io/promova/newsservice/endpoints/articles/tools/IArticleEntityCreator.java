package io.promova.newsservice.endpoints.articles.tools;

import io.promova.newsservice.reps.ArticleEntity;

public interface IArticleEntityCreator
{
    ArticleEntity create(String id, String article);
}
