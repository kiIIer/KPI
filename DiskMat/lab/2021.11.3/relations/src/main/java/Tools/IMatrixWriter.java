package Tools;

import java.io.IOException;

public interface IMatrixWriter
{
    void write(int[][] matrix, String filename) throws IOException;
}
