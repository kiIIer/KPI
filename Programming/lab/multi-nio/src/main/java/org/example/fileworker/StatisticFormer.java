package org.example.fileworker;

import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class StatisticFormer extends RecursiveAction
{
    private final List<Job> workload;
    private static final int THRESHOLD = 1;

    public StatisticFormer(List<Job> workload)
    {
        this.workload = workload;
    }

    @Override
    protected void compute()
    {
        if (workload.size() > THRESHOLD)
        {
            ForkJoinTask.invokeAll(createSubtasks());
        } else
        {
            processing();
        }
    }

    private List<StatisticFormer> createSubtasks()
    {
        List<StatisticFormer> subtasks = new LinkedList<>();
        subtasks.add(new StatisticFormer(workload.subList(0, THRESHOLD)));
        subtasks.add(new StatisticFormer(workload.subList(THRESHOLD, workload.size())));

        return subtasks;
    }

    private void processing()
    {
        for (Job job : workload)
        {
            Map<String, AtomicInteger> wordMap = formWordMap(job.file());
            String rarestWord = findRarest(wordMap);

            job.statistics().add(new StatisticUnit(job.file().getName(), rarestWord));
        }
    }

    private String findRarest(Map<String, AtomicInteger> wordMap)
    {
        Map.Entry<String, AtomicInteger> rarest = null;
        for (Map.Entry<String, AtomicInteger> entry : wordMap.entrySet())
        {
            if (rarest == null)
            {
                rarest = entry;
                continue;
            }
            if (entry.getValue().get() < rarest.getValue().get())
            {
                rarest = entry;
            }
        }

        return rarest.getKey();
    }

    private Map<String, AtomicInteger> formWordMap(File file)
    {
        Map<String, AtomicInteger> wordMap = new HashMap<>();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r"))
        {
            FileChannel channel = randomAccessFile.getChannel();
            Charset charset = StandardCharsets.US_ASCII;
            ByteBuffer byteBuffer = ByteBuffer.allocate(1 << 11);
            StringBuilder word = new StringBuilder();
            while (channel.read(byteBuffer) > 0)
            {
                byteBuffer.flip();
                CharBuffer charBuffer = charset.decode(byteBuffer);
                while (charBuffer.hasRemaining())
                {
                    char current = charBuffer.get();
                    if (Character.isWhitespace(current))
                    {
                        AtomicInteger count = wordMap.get(word.toString());
                        if (count == null)
                        {
                            count = new AtomicInteger();
                            wordMap.put(word.toString(), count);
                        }
                        count.incrementAndGet();
                        word = new StringBuilder();
                        continue;
                    }
                    word.append(current);
                }

                byteBuffer.clear();
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return wordMap;
    }
}
