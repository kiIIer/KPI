package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to add students. Is a subcommand of CLIAddCommand
 */
public interface IAddStudentCommand extends Callable<Integer>
{
    /**
     * Call of the CLIAddStudentCommand. Adds Student as instructed.
     *
     * @return Exit code of CLIAddDepartmentCommand.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
