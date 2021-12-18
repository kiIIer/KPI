package Commands;

import java.util.concurrent.Callable;

public interface IGraphCheckCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
