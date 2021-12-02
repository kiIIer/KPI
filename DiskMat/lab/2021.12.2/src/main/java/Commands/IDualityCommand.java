package Commands;

import java.util.concurrent.Callable;

public interface IDualityCommand extends Callable<Integer>
{
    @Override
    Integer call();
}
