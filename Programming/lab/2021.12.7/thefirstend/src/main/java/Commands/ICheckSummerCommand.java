package Commands;

import java.util.concurrent.Callable;

public interface ICheckSummerCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
