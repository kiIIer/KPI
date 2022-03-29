package io.promova.newsservice.reps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "articles")
public class ArticleEntity
{
    @Id
    @Column
    @NotNull
    private String id;

    @Column
    @NotNull
    private String article;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getArticle()
    {
        return article;
    }

    public void setArticle(String article)
    {
        this.article = article;
    }

    public ArticleEntity(String id, String article)
    {
        this.id = id;
        this.article = article;
    }

    public ArticleEntity()
    {
    }
}
