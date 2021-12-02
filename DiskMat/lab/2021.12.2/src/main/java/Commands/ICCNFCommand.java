package Commands;

import java.util.concurrent.Callable;

public interface ICCNFCommand extends Callable<Integer>
{
    @Override
    Integer call();
}
