package io.promova.newsservice.endpoints.articles.entities;

public class OneArticleRequest
{
    private String article;

    public String getArticle()
    {
        return article;
    }

    public void setArticle(String article)
    {
        this.article = article;
    }

    public OneArticleRequest(String article)
    {
        this.article = article;
    }

    public OneArticleRequest()
    {
    }
}
