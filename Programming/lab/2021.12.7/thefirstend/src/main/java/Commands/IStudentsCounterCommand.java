package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * This command tells how many students are there in institue as instructed.
 */
public interface IStudentsCounterCommand extends Callable<Integer>
{
    /**
     * Call of CLI_StudentsCounterCommand.
     *
     * @return Exit code of this command.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
