package io.promova.killer.mathmaid.result.responce;

public class FormulaDTO
{
    public final long id;
    public final String[] parameters;

    public FormulaDTO(long id, String[] parameters)
    {
        this.id = id;
        this.parameters = parameters;
    }
}
