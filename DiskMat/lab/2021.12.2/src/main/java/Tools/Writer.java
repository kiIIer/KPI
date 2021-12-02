package Tools;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Writer implements IWriter
{
    @Override
    public void write(String[][] matrix) throws Exception
    {
        CSVWriter writer = new CSVWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for (String[] line : matrix)
        {
            writer.writeNext(line);
        }
        writer.close();
    }
}
