package Commands;

import java.util.concurrent.Callable;

public interface IFirstLongestCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
