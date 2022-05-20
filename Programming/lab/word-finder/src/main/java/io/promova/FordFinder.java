package io.promova;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FordFinder implements IFordFinder
{
    @Override
    public String find(File file) throws IOException
    {
        Map<String, AtomicInteger> wordMap = formMap(file);
        return findRearrestWord(wordMap);
    }

    private Map<String, AtomicInteger> formMap(File file) throws IOException
    {
        Map<String, AtomicInteger> wordMap = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file))))
        {
            char[] charBuffer = new char[1 << 11];
            StringBuilder stringBuilder = new StringBuilder();
            while (true)
            {
                int charsRead = bufferedReader.read(charBuffer);
                if (!(charsRead > 0))
                {
                    break;
                }

                for (int i = 0; i < charsRead; i++)
                {
                    char current = charBuffer[i];
                    if (current == ' ')
                    {
                        String word = stringBuilder.toString();
                        AtomicInteger atomicInteger = wordMap.get(word);
                        if (atomicInteger == null)
                        {
                            atomicInteger = new AtomicInteger();
                            wordMap.put(word, atomicInteger);
                        }
                        atomicInteger.incrementAndGet();
                        stringBuilder = new StringBuilder();
                    } else
                    {
                        stringBuilder.append(current);
                    }

                }
            }
        }

        return wordMap;
    }

    private String findRearrestWord(Map<String, AtomicInteger> wordMap)
    {
        Map.Entry<String, AtomicInteger> rearrestOne = null;
        for (Map.Entry<String, AtomicInteger> entry : wordMap.entrySet())
        {
            if (rearrestOne == null)
            {
                rearrestOne = entry;
                continue;
            }

            if (rearrestOne.getValue().get() > entry.getValue().get())
            {
                rearrestOne = entry;
            }
        }

        return rearrestOne.getKey();
    }
}
