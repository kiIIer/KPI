package io.promova.tablemath.endpoints.tools;

public class FormulaSolver implements IFormulaSolver
{
    @Override
    public long solve(long a, long b)
    {
        return a * factorial(b);
    }

    private long factorial(long n)
    {
        long fact = 1;
        for (int i = 2; i <= n; i++)
        {
            fact = fact * i;
        }
        return fact;
    }
}
