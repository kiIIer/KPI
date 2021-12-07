package Main.FileWorker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckSummer implements ICheckSummer
{
    @Override
    public byte checkSum(String filename) throws IOException
    {
        Path path = Paths.get(filename);

        byte[] bytes = Files.readAllBytes(path);

        byte sum = 0;

        for (byte bait :
                bytes)
        {
            sum ^= bait;
        }

        return sum;
    }
}
