package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

public interface ICalculateTreeCommand extends Callable<Integer>
{
    @Override
    Integer call() throws CommandLine.ParameterException;
}
