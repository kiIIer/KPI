package Checkers;

public class TOne implements ITOne
{
    @Override
    public boolean check(String tuple)
    {
        return tuple.toCharArray()[7] == '1';
    }
}
