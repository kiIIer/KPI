import Commands.AppCommand;
import Commands.HexCommand;
import Commands.NumberOfWordsCommand;
import com.google.inject.Inject;
import picocli.CommandLine;

public class CLIInitializer implements ICLIInitializer
{
    private final AppCommand appCommand;
    private final HexCommand hexCommand;
    private final NumberOfWordsCommand numberOfWordsCommand;

    @Inject
    public CLIInitializer(
            AppCommand appCommand,
            HexCommand hexCommand,
            NumberOfWordsCommand numberOfWordsCommand
    )
    {

        this.appCommand = appCommand;
        this.hexCommand = hexCommand;
        this.numberOfWordsCommand = numberOfWordsCommand;
    }

    @Override
    public CommandLine initialize()
    {
        CommandLine commandLine = new CommandLine(appCommand);

        commandLine.addSubcommand(CommandLine.HelpCommand.class);
        commandLine.addSubcommand("hex", hexCommand);
        commandLine.addSubcommand("number-of-words", numberOfWordsCommand);

        return commandLine;
    }
}
