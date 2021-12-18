package Main;

import Commands.*;
import picocli.CommandLine;

import javax.inject.Inject;

public class CLIBuilder implements ICLIBuilder
{
    private final IAppCommand appCommand;
    private final ICalculateTreeCommand calculateTreeCommand;
    private final IGraphCheckCommand graphCheckCommand;
    private final IPostfixTableCommand postfixTableCommand;
    private final IPrefixTableCommand prefixTableCommand;
    private final IShowTreeCommand showTreeCommand;

    @Inject
    public CLIBuilder(
            IAppCommand appCommand,
            ICalculateTreeCommand calculateTreeCommand,
            IGraphCheckCommand graphCheckCommand,
            IPostfixTableCommand postfixTableCommand,
            IPrefixTableCommand prefixTableCommand,
            IShowTreeCommand showTreeCommand
    )
    {
        this.appCommand = appCommand;
        this.calculateTreeCommand = calculateTreeCommand;

        this.graphCheckCommand = graphCheckCommand;
        this.postfixTableCommand = postfixTableCommand;
        this.prefixTableCommand = prefixTableCommand;
        this.showTreeCommand = showTreeCommand;
    }

    @Override
    public CommandLine build()
    {
        CommandLine commandLine = new CommandLine(appCommand);

        commandLine.addSubcommand(CommandLine.HelpCommand.class);
        commandLine.addSubcommand(calculateTreeCommand);
        commandLine.addSubcommand(graphCheckCommand);
        commandLine.addSubcommand(postfixTableCommand);
        commandLine.addSubcommand(prefixTableCommand);
        commandLine.addSubcommand(showTreeCommand);

        return commandLine;
    }
}
