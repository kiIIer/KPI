package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to calculate and output checkSum - Exclusive disjunction on all bytes of file.
 */
public interface ICheckSummerCommand extends Callable<Integer>
{
    /**
     * Call of CLI_CheckSummerCommand.
     *
     * @return Exit code of this command
     * @throws CommandLine.ParameterException Will be thrown when IOException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
