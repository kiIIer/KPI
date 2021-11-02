package Tools;

public class Subseter implements ISubseter
{
    @Override
    public boolean assertSubset(Set set1, Set set2){
        return (set1.binary | set2.binary) == set2.binary;
    }
}
