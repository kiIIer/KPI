package Preparators;

import Tools.BinaryMap;
import Tools.Symbols;

public class CCNF implements ICCNF
{
    @Override
    public String translate(String tuple)
    {
        StringBuilder builder = new StringBuilder();

        char[] chars = tuple.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == '1')
            {
                continue;
            }
            addCon(i, builder);
            builder.append(" ").append(Symbols.CONJUNCTION).append(" ");
        }

        if (builder.length() != 0)
        {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    private void addCon(int combo, StringBuilder builder)
    {
        int binaryX = BinaryMap.mapColumn.get(0);
        if ((combo & binaryX) == binaryX)
        {
            builder.append(Symbols.NOT_X);
        } else
        {
            builder.append(Symbols.X);
        }

        builder.append(Symbols.DISJUNCTION);

        int binaryY = BinaryMap.mapColumn.get(1);
        if ((combo & binaryY) == binaryY)
        {
            builder.append(Symbols.NOT_Y);
        } else
        {
            builder.append(Symbols.Y);
        }

        builder.append(Symbols.DISJUNCTION);

        int binaryZ = BinaryMap.mapColumn.get(2);
        if ((combo & binaryZ) == binaryZ)
        {
            builder.append(Symbols.NOT_Z);
        } else
        {
            builder.append(Symbols.Z);
        }
    }
}
