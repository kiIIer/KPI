package Commands;

import java.util.concurrent.Callable;

public interface ICDNFCommand extends Callable<Integer>
{
    @Override
    Integer call();
}
