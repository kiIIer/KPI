package Preparators;

public class Duality implements IDuality
{
    @Override
    public String translate(String tuple)
    {
        char[] chars = tuple.toCharArray();

        swap(chars);

        StringBuilder builder = new StringBuilder();

        for (int i = tuple.length(); i > 0; i--)
        {
            builder.append(chars[i - 1]);
        }

        return builder.toString();
    }

    private void swap(char[] chars)
    {
        for (int i = 0; i < chars.length; i++)
        {
            chars[i] = (chars[i] == '1') ? '0' : '1';
        }
    }
}
