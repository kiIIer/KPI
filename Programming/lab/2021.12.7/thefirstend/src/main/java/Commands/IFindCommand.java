package Commands;

import java.util.concurrent.Callable;

public interface IFindCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
