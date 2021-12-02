package Commands;

import java.util.concurrent.Callable;

public interface IZhegalkinPolynomialCommand extends Callable<Integer>
{
    @Override
    Integer call();
}
