package Commands;

import java.util.concurrent.Callable;

public interface ICompositionCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
