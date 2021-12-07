package Commands;

import java.util.concurrent.Callable;

public interface IShowCommand extends Callable<Integer>
{
    Integer call();
}
