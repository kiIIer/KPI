package Main;

import picocli.CommandLine;

/**
 * Command line interface builder. Has all the Command classes injected in it.
 */
public interface ICLIBuilder
{
    /**
     * Builds command line interface using all commands. Adding subcommands and subsubcommands.
     * @return Fully built CLI. ready to use.
     */
    CommandLine build();
}
