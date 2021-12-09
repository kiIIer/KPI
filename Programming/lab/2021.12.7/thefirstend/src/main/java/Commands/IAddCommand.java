package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Base command of tree Add. All Add Commands are subcommands of this command.
 */
public interface IAddCommand extends Callable<Integer>
{
    /**
     * Call of the CLIAddCommand. It does nothing special, only says that it can't do anything.
     * @return Exit code of CLIAddCommand.
     */
    @Override
    Integer call();
}
