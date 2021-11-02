package Tools;

public class Equaler implements IEqualer
{
    @Override
    public boolean assertEqual(Set set1, Set set2){
        return set1.binary == set2.binary;
    }
}
