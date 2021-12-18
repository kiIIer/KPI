package CSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MatrixReader implements IMatrixReader
{
    @Override
    public int[][] read(String filename) throws IOException, CsvException, NumberFormatException
    {
        CSVReader reader = new CSVReader(new FileReader(filename));

        List<String[]> csv = reader.readAll();

        int[][] matrix = new int[csv.size()][];

        for (int rowIndex = 0; rowIndex < csv.size(); rowIndex++)
        {
            String[] csvRow = csv.get(rowIndex);
            int[] row = new int[csvRow.length];

            for (int columnIndex = 0; columnIndex < csvRow.length; columnIndex++)
            {
                row[columnIndex] = Integer.parseInt(csvRow[columnIndex]);
            }

            matrix[rowIndex] = row;
        }
        return matrix;
    }
}
