package Commands;

import java.util.concurrent.Callable;

public interface IShowDepartmentCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
