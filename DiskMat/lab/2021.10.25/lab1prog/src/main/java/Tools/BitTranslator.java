package Tools;

public class BitTranslator implements IBitTranslator
{
    public int toBit(int[] set)
    {
        int bit = 0;

        for (int element : set)
        {
            bit = bit | toBit(element - 1);
        }

        return bit;
    }

    public String bitToBitString(int bit)
    {
        String bitString = "";

        for (int i = 0; i < Universe.values().length; i++)
        {
            int bitI = toBit(i);
            if ((bit & bitI) == bitI)
            {
                bitString = "1" + bitString;
                continue;
            }
            bitString = "0" + bitString;
        }
        return bitString;
    }

    private int toBit(int element)
    {
        return Universe.values()[element].getBitFlag();
    }
}
