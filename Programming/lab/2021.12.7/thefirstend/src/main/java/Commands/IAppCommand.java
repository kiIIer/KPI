package Commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Root CLI command. All the other commands are subcommands of this command.
 */
public interface IAppCommand extends Callable<Integer>
{
    /**
     * Call of the CLIAppCommand. Will be called when app is launched without command specification. It does nothing special, only greets the user.
     *
     * @return Exit code of the Callable.
     */
    @Override
    Integer call();
}
