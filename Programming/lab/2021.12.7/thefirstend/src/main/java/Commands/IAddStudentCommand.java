package Commands;

import java.util.concurrent.Callable;

public interface IAddStudentCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
