package Preparators;

import Tools.BinaryMap;
import Tools.Symbols;

public class TruthTable implements ITruthTable
{


    @Override
    public String[][] translate(String tuple)
    {
        char[] values = tuple.toCharArray();

        String[][] matrix = new String[9][4];
        matrix[0][0] = String.valueOf(Symbols.X);
        matrix[0][1] = String.valueOf(Symbols.Y);
        matrix[0][2] = String.valueOf(Symbols.Z);
        matrix[0][3] = String.format("f(%c, %c, %c)", Symbols.X, Symbols.Y, Symbols.Z);

        fillTable(matrix, values);

        return matrix;
    }

    private void fillTable(String[][] matrix, char[] values)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 1; i < rows; i++)
        {
            for (int j = 0; j < columns - 1; j++)
            {
                matrix[i][j] = fillCell(i, j);
            }
            matrix[i][columns - 1] = String.valueOf(values[i - 1]);
        }
    }

    private String fillCell(int i, int j)
    {
        int binary = BinaryMap.mapColumn.get(j);
        return ((i - 1 & binary) == binary) ? "1" : "0";
    }
}
