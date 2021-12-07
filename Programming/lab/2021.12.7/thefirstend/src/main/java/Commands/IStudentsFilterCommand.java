package Commands;

import java.util.concurrent.Callable;

public interface IStudentsFilterCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
