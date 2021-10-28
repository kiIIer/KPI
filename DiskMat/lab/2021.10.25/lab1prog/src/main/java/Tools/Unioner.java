package Tools;

public class Unioner implements IUnioner
{
    public Set calculate(Set set1, Set set2)
    {
        return new Set(set1.binary | set2.binary);
    }
}
