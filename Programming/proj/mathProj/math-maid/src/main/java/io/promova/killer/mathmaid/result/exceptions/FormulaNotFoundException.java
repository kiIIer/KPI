package io.promova.killer.mathmaid.result.exceptions;

public class FormulaNotFoundException extends RuntimeException
{
    public FormulaNotFoundException(Long id)
    {
        super("Couldn't find formula with id: " + id);
    }

}
