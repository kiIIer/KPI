package Commands;

import java.util.concurrent.Callable;

public interface IRemoveCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
