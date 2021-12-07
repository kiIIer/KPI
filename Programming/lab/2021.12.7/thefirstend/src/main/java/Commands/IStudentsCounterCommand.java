package Commands;

import java.util.concurrent.Callable;

public interface IStudentsCounterCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
