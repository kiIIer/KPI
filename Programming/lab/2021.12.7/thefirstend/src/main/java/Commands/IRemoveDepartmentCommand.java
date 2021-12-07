package Commands;

import java.util.concurrent.Callable;

public interface IRemoveDepartmentCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
