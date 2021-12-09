package Main.FileWorker;

import java.io.IOException;

/**
 * Class to find checkSum.
 */
public interface ICheckSummer
{
    /**
     * Finds checkSum in provided file
     *
     * @param filename Name of desired file.
     * @return checkSum
     * @throws IOException When File cannot be read or is deleted, well the usual stuff.
     */
    byte checkSum(String filename) throws IOException;
}
