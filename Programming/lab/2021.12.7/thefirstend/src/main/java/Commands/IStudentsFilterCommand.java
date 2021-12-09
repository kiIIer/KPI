package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * This command filters students as instructed.
 */
public interface IStudentsFilterCommand extends Callable<Integer>
{
    /**
     * Call of CLI_StudentsFilterCommand.
     *
     * @return Exit code of this command.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
