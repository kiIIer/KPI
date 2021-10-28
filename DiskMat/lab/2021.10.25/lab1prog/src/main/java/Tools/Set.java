package Tools;

import java.util.*;

public class Set
{
    private static final Map<Integer, Integer> element2Binary;
    private static final Map<Integer, Integer> binary2Element;

    public int binary = 0;
    public int[] elements;
    public final int[] invalidNumbers;

    static
    {
        element2Binary = new HashMap<Integer, Integer>();
        element2Binary.put(1, 1);
        element2Binary.put(2, 1 << 1);
        element2Binary.put(3, 1 << 2);
        element2Binary.put(4, 1 << 3);
        element2Binary.put(5, 1 << 4);
        element2Binary.put(6, 1 << 5);
        element2Binary.put(7, 1 << 6);
        element2Binary.put(8, 1 << 7);

        binary2Element = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : element2Binary.entrySet())
        {
            binary2Element.put(entry.getValue(), entry.getKey());
        }
    }

    public Set(int[] numbers)
    {
        Map<Integer, Integer> validNumbers = new HashMap<>();

        Map<Integer, Integer> invalidNumbers = new HashMap<>();

        for (int number : numbers)
        {
            int binary = toBinary(number);
            this.binary |= binary;

            if (binary != 0 && !validNumbers.containsKey(number))
            {
                validNumbers.put(number, number);
            }
            if (binary == 0 && !invalidNumbers.containsKey(number))
            {
                invalidNumbers.put(number, number);
            }
        }
        this.elements = convert(validNumbers.keySet().toArray(new Integer[0]));
        this.invalidNumbers = convert(invalidNumbers.keySet().toArray(new Integer[0]));
    }

    public Set(int binary)
    {
        this.binary = binary;

        List<Integer> elements = new ArrayList<Integer>();

        for (var entry : binary2Element.entrySet())
        {
            if ((binary & entry.getKey()) != entry.getKey())
            {
                continue;
            }

            elements.add(entry.getValue());
        }

        this.elements = convert(elements.toArray(new Integer[0]));
        this.invalidNumbers = new int[0];
    }

    private int toBinary(int number)
    {
        Integer binary = element2Binary.get(number);
        return (binary == null) ? 0 : binary;
    }

    private int[] convert(Integer[] array)
    {
        int[] result = new int[array.length];

        for (int i = 0; i < result.length; i++)
        {
            result[i] = array[i];
        }
        return result;
    }
}
