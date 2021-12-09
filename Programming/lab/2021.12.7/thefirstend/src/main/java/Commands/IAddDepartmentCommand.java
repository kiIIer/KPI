package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to add departments. Is subcommand of CLIAddCommand.
 */
public interface IAddDepartmentCommand extends Callable<Integer>
{
    /**
     * Call of the CLIAddDepartmentCommand. Adds Department as instructed.
     * @return Exit code of CLIAddDepartmentCommand.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
