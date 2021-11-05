package Commands;

import java.util.concurrent.Callable;

public interface IClosureCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
