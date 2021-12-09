package Main.FileWorker;

import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

public class FirstLongestStringFinder implements IFirstLongestStringFinder
{
    @Override
    public String find(String filename) throws IOException
    {
        File file = new File(filename);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String longestString = null;
        Stream<String> lines = reader.lines();
        for (Iterator<String> iterator = lines.iterator(); iterator.hasNext(); )
        {
            String s = iterator.next();

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
