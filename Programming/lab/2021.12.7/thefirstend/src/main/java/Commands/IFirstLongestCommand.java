package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to find the longest row in a file.
 */
public interface IFirstLongestCommand extends Callable<Integer>
{
    /**
     * Call of CLI_FirstLongestCommand
     *
     * @return Exit code of the command.
     * @throws CommandLine.ParameterException Will be thrown when IOException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
