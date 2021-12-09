package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to show institute as instructed. Is a subcommand of CLIShowCommand.
 */
public interface IShowInstituteCommand extends Callable<Integer>
{
    /**
     * Call of CLIShowInstituteCommand. Shows the institute.
     *
     * @return Exit code of this command.
     * @throws CommandLine.ParameterException Will be thrown when IOException or InvalidDataStructureException occurs. This exception is caught and displayed by PicoCLI.
     */
    @Override
    Integer call() throws CommandLine.ParameterException;
}
