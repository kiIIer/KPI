package Commands;

import java.util.concurrent.Callable;

public interface IAddDepartmentCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
