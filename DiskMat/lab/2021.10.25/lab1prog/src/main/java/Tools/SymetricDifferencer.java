package Tools;

public class SymetricDifferencer implements ISymetricDifferencer
{
    public Set calculate(Set set1, Set set2)
    {
        return new Set((set1.binary & (~set2.binary)) | (set2.binary & (~set1.binary)));
    }
}
