package io.promova.killer.mathmaid.rep;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "formulas")
public class FormulaEntity
{
    @Id
    @Column
    private long id;

    @Column
    @NotNull
    private String polish;

    @Column
    @NotNull
    private String params;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getPolish()
    {
        return polish;
    }

    public void setPolish(String polish)
    {
        this.polish = polish;
    }

    public String getParams()
    {
        return params;
    }

    public void setParams(String params)
    {
        this.params = params;
    }

    public FormulaEntity()
    {
    }
}
