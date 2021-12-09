package Commands;

import java.util.concurrent.Callable;

/**
 * Base command to show commands. All CLIShowCommands are subcommands of this command.
 */
public interface IShowCommand extends Callable<Integer>
{
    /**
     * Call of CLIShowCommand. Does nothing useful.
     * @return Exit code of this command.
     */
    Integer call();
}
