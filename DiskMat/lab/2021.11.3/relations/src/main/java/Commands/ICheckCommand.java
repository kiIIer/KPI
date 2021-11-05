package Commands;

import java.util.concurrent.Callable;

public interface ICheckCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
