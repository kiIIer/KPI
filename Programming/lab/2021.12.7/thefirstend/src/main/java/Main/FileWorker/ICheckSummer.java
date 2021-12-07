package Main.FileWorker;

import java.io.IOException;

public interface ICheckSummer
{
    byte checkSum(String filename) throws IOException;
}
