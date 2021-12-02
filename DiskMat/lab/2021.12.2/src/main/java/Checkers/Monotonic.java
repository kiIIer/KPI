package Checkers;

public class Monotonic implements IMonotonic
{
    @Override
    public boolean check(String tuple)
    {
        char[] chars = tuple.toCharArray();

        int[] ints = toInts(chars);

        for (int i = 0; i < ints.length; i++)
        {
            for (int j = 0; j < ints.length; j++)
            {
                if ((i | j) == j)
                {
                    if (ints[i] > ints[j])
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int[] toInts(char[] chars)
    {
        int[] ints = new int[chars.length];

        for (int i = 0; i < chars.length; i++)
        {
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        return ints;
    }
}
