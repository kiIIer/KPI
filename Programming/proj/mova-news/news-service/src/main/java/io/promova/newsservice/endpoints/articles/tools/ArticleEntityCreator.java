package io.promova.newsservice.endpoints.articles.tools;

import io.promova.newsservice.reps.ArticleEntity;

public class ArticleEntityCreator implements IArticleEntityCreator
{
    @Override
    public ArticleEntity create(String id, String article)
    {
        return new ArticleEntity(id, article);
    }
}
