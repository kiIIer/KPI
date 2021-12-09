package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Base command for all CLI_RemoveCommands. Add CLI_RemoveCommands are subcommands of this command.
 */
public interface IRemoveCommand extends Callable<Integer>
{
    /**
     * Call of CLI_RemoveCommand. Says "Never existed..." -  Chrono Legionnaire, an unknown warrior from RedAlert.
     * @return Exit code of this command.
     */
    @Override
    Integer call();
}
