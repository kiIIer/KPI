package Main.FileWorker;

import java.io.*;

public class FirstLongestStringFinder implements IFirstLongestStringFinder
{
    @Override
    public String find(String filename) throws IOException
    {
        File file = new File(filename);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String longestString = null;
        while (true)
        {
            String s = reader.readLine();

            if (s == null)
            {
                break;
            }

            if (longestString == null)
            {
                longestString = s;
            }

            if (s.length() > longestString.length())
            {
                longestString = s;
            }
        }
        reader.close();
        return longestString;
    }
}
