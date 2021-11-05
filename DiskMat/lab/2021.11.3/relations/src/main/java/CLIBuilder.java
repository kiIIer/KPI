import Commands.IAppCommand;
import Commands.ICheckCommand;
import Commands.IClosureCommand;
import Commands.ICompositionCommand;
import Tools.IRelationComposer;
import com.google.inject.Inject;
import picocli.CommandLine;

public class CLIBuilder implements ICLIBuilder
{

    private final IAppCommand appCommand;
    private final ICheckCommand checkCommand;
    private final ICompositionCommand compositionCommand;
    private final IClosureCommand closureCommand;

    @Inject
    public CLIBuilder(
            IAppCommand appCommand,
            ICheckCommand checkCommand,
            ICompositionCommand compositionCommand,
            IClosureCommand closureCommand
    )
    {
        this.appCommand = appCommand;
        this.checkCommand = checkCommand;
        this.compositionCommand = compositionCommand;
        this.closureCommand = closureCommand;
    }

    @Override
    public CommandLine build()
    {
        var commandLine = new CommandLine(appCommand);

        commandLine.addSubcommand(CommandLine.HelpCommand.class);
        commandLine.addSubcommand(checkCommand);
        commandLine.addSubcommand(compositionCommand);
        commandLine.addSubcommand(closureCommand);

        return commandLine;
    }
}
