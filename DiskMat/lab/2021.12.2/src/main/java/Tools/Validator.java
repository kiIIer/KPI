package Tools;

public class Validator implements IValidator
{
    @Override
    public boolean validate(String tuple)
    {
        if (tuple.toCharArray().length != 8)
        {
            return false;
        }

        for (char c : tuple.toCharArray())
        {
            if (!(c == '0' || c == '1'))
            {
                return false;
            }
        }
        return true;
    }
}
