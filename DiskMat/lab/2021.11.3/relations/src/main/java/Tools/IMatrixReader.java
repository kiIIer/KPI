package Tools;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public interface IMatrixReader
{
    int[][] read(String filename) throws NumberFormatException, IOException, CsvException;
}
