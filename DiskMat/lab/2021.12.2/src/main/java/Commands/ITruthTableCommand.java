package Commands;

import java.util.concurrent.Callable;

public interface ITruthTableCommand extends Callable<Integer>
{
    @Override
    Integer call();
}
