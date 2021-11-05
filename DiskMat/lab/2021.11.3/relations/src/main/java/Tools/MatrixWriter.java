package Tools;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MatrixWriter implements IMatrixWriter
{
    @Override
    public void write(int[][] matrix, String filename) throws IOException
    {
        CSVWriter writer = new CSVWriter(new FileWriter(new File(filename)));

        List<String[]> csv = new ArrayList<String[]>();

        for (int[] row : matrix)
        {
            String[] line = new String[row.length];
            for (int i = 0; i < row.length; i++)
            {
                line[i] = String.valueOf(row[i]);
            }
            csv.add(line);
        }

        writer.writeAll(csv);

        writer.close();
    }
}
