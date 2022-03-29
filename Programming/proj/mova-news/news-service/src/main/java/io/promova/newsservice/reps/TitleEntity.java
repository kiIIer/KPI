package io.promova.newsservice.reps;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "titles")
public class TitleEntity
{
    @Id
    @Column
    @NotNull
    private String id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private Long dateCreated;

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

    public Long getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public TitleEntity(String id, String title, Long dateCreated)
    {
        this.id = id;
        this.title = title;
        this.dateCreated = dateCreated;
    }

    public TitleEntity()
    {
    }
}
