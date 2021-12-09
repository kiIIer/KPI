package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * This command fined and prints the largest department.
 */
public interface IFindCommand extends Callable<Integer>
{
    /**
     * Call of CLI_FindCommand.
     *
     * @return Exit code of this command.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
