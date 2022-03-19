package io.promova.newsservice.rep;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "news")
public class NewsEntity
{
    @Id
    @Column
    private String id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String article;

    @Column
    @NotNull
    private Long datecreated;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArticle()
    {
        return article;
    }

    public void setArticle(String article)
    {
        this.article = article;
    }

    public Long getDatecreated()
    {
        return datecreated;
    }

    public void setDatecreated(Long dateCreated)
    {
        this.datecreated = dateCreated;
    }

    public NewsEntity()
    {
    }

    public NewsEntity(String id, String title, String article, long datecreated)
    {
        this.id = id;
        this.title = title;
        this.article = article;
        this.datecreated = datecreated;
    }
}
