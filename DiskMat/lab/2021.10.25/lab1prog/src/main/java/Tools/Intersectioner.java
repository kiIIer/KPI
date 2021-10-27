package Tools;

public class Intersectioner implements IIntersectioner
{
    public int calculate(int set1, int set2)
    {
        return set1 & set2;
    }
}
