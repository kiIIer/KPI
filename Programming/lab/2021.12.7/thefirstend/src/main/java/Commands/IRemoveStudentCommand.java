package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to remove students as instucted. Is a subcommand of CLI_RemoveCommand
 */
public interface IRemoveStudentCommand extends Callable<Integer>
{
    /**
     * Call of CLI_RemoveStudentCommand. Removes student.
     *
     * @return Exit code of Command.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
