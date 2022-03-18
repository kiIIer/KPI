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
    private long id;

    @Column
    @NotNull
    private String header;

    @Column
    @NotNull
    private String body;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public NewsEntity()
    {
    }

    public NewsEntity(int id, String header, String body)
    {
        this.id = id;
        this.header = header;
        this.body = body;
    }
}
