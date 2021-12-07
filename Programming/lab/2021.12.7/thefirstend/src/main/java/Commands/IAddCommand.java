package Commands;

import java.util.concurrent.Callable;

public interface IAddCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
