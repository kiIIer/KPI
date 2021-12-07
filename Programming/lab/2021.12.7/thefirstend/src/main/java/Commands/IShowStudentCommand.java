package Commands;

import java.util.concurrent.Callable;

public interface IShowStudentCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
