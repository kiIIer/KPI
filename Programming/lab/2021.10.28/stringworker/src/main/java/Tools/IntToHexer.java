package Tools;

public class IntToHexer implements IIntToHexer
{
    @Override
    public String convert(int number)
    {
        return String.format("%x", number);
    }
}
