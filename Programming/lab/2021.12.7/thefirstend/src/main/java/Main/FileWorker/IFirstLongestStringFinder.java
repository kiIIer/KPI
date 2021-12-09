package Main.FileWorker;

import java.io.IOException;

/**
 * This class finds the largest line.
 */
public interface IFirstLongestStringFinder
{
    /**
     * Line with the largest amount of characters in it in provided file. If there are multiple strings, the first one will be returned.
     *
     * @param filename Name of file to be used in finding process.
     * @return The first longest line
     * @throws IOException Just the usual stuff when working with files.
     */
    String find(String filename) throws IOException;
}
