package Preparators;

import Tools.BinaryMap;
import Tools.Symbols;

public class CDNF implements ICDNF
{
    @Override
    public String translate(String tuple)
    {
        StringBuilder builder = new StringBuilder();

        char[] chars = tuple.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == '0')
            {
                continue;
            }
            addDis(i, builder);
            builder.append(" ").append(Symbols.DISJUNCTION).append(" ");
        }

        if (builder.length() != 0)
        {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    private void addDis(int combo, StringBuilder builder)
    {
        int binaryX = BinaryMap.mapColumn.get(0);
        if ((combo & binaryX) == binaryX)
        {
            builder.append(Symbols.X);
        } else
        {
            builder.append(Symbols.NOT_X);
        }

        builder.append(Symbols.CONJUNCTION);

        int binaryY = BinaryMap.mapColumn.get(1);
        if ((combo & binaryY) == binaryY)
        {
            builder.append(Symbols.Y);
        } else
        {
            builder.append(Symbols.NOT_Y);
        }

        builder.append(Symbols.CONJUNCTION);

        int binaryZ = BinaryMap.mapColumn.get(2);
        if ((combo & binaryZ) == binaryZ)
        {
            builder.append(Symbols.Z);
        } else
        {
            builder.append(Symbols.NOT_Z);
        }
    }
}
