package Commands;

import java.util.concurrent.Callable;

public interface IShowInstituteCommand extends Callable<Integer>
{
    @Override
    Integer call() throws Exception;
}
