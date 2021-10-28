package Tools;

public class Differencer implements IDifferencer
{
    public Set calculate(Set set1, Set set2)
    {
        return new Set(set1.binary & (~set2.binary));
    }
}
