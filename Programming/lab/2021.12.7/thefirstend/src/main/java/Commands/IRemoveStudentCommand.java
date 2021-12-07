package Commands;

import java.util.concurrent.Callable;

public interface IRemoveStudentCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
