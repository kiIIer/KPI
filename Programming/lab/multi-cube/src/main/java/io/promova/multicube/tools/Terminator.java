package io.promova.multicube.tools;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Terminator implements Runnable
{
    private final Semaphore semaphore;
    private final ExecutorService executorService;

    public Terminator(Semaphore semaphore, ExecutorService executorService)
    {
        this.semaphore = semaphore;
        this.executorService = executorService;
    }

    @Override
    public void run()
    {
        try
        {
            semaphore.acquire(Integer.MAX_VALUE);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
