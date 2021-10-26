package Tools;

public class BitTranslator implements IBitTranslator
{
    public int toBit(int[] set)
    {
        int bit = 0;

        for (int element : set)
        {
            bit = bit | toBit(element);
        }

        return bit;
    }

    private int toBit(int element)
    {
       return Universe.values()[element-1].getBitFlag();
    }
}
