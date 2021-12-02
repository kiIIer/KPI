package Preparators;

import Tools.BinaryMap;
import Tools.Symbols;

public class ZhegalkinPolynomial implements IZhegalkinPolynomial
{
    @Override
    public String translate(String tuple)
    {
        char[] chars = tuple.toCharArray();
        int[][] matrix = new int[8][8];

        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][0] = Integer.parseInt(String.valueOf(chars[i]));
        }

        fillTheMatrixUp(matrix);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[0][i] == 1)
            {
                getChlen(i, builder);
                builder.append(" ").append(Symbols.EXCLUSIVE_DISJUNCTION).append(" ");
            }
        }

        if (builder.length() != 0)
        {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    private void fillTheMatrixUp(int[][] matrix)
    {
        for (int i = 1; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length - i; j++)
            {
                matrix[j][i] = (matrix[j][i - 1] == matrix[j + 1][i - 1]) ? 0 : 1;
            }
        }
    }

    private void getChlen(int i, StringBuilder builder)
    {
        if (i == 0)
        {
            builder.append("1");
            return;
        }

        int xBinary = BinaryMap.mapColumn.get(0);
        int yBinary = BinaryMap.mapColumn.get(1);
        int zBinary = BinaryMap.mapColumn.get(2);

        boolean x = (i & xBinary) == xBinary;
        boolean y = (i & yBinary) == yBinary;
        boolean z = (i & zBinary) == zBinary;
        boolean shouldAdd = false;

        if (x)
        {
            builder.append(Symbols.X);
            shouldAdd = true;
        }

        if (y)
        {
            if (shouldAdd)
            {
                builder.append(Symbols.CONJUNCTION);
            }
            builder.append(Symbols.Y);
            shouldAdd = true;
        }

        if (z)
        {
            if (shouldAdd)
            {
                builder.append(Symbols.CONJUNCTION);
            }
            builder.append(Symbols.Z);
        }
    }
}
