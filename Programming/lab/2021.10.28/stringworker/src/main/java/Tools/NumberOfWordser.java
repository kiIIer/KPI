package Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfWordser implements INumberOfWordser
{
    @Override
    public long calculate(String string)
    {
        Pattern wordPattern = Pattern.compile("\\b[^\\d\\W]+\\b");

        Matcher matcher = wordPattern.matcher(string);

        return matcher.results().count();
    }
}
