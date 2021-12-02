package Checkers;

public class TZero implements ITZero
{
    @Override
    public boolean check(String tuple)
    {
        return tuple.toCharArray()[0] == '0';
    }
}
