package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command which shows student as instructed. Is a subcommand of CLI_ShowCommand
 */
public interface IShowStudentCommand extends Callable<Integer>
{
    /**
     * Call of CLI_ShowStudentCommand. Shows student.
     *
     * @return Exit code of this command.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
