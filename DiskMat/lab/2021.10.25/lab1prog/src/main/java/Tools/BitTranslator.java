package Tools;

import java.util.ArrayList;
import java.util.List;

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
            if (hasIn(bit, bitI))
            {
                bitString = "1" + bitString;
                continue;
            }
            bitString = "0" + bitString;
        }
        return bitString;
    }

    public int[] bitToArray(int bit){
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < Universe.values().length; i++){
            if(hasIn(bit, toBit(i))){
               list.add(i+1);
            }
        }
        return listToArray(list);
    }

    private int[] listToArray(List<Integer> list){
        int[] array = new int[list.size()];

        for(int i = 0; i < array.length; i ++){
            array[i] = list.get(i);
        }
        return  array;
    }

    public int toBit(int element)
    {
        return Universe.values()[element].getBitFlag();
    }

    private boolean hasIn(int bit, int element){
        return (bit & element) == element;
    }
}
