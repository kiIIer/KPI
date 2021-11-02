package Tools;

public class Complementer implements Tools.IComplementer
{
    public Set calculate(Set set)
    {
        return new Set(~set.binary);
    }
}
