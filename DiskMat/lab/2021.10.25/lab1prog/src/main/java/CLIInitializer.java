import Commands.BitShowCommand;
import Commands.IAppCommand;
import Commands.UnionCommand;
import com.google.inject.Inject;
import picocli.CommandLine;

public class CLIInitializer implements ICLIInitializer
{
    private final IAppCommand appCommand;
    private final UnionCommand unionCommand;
    private final BitShowCommand bitShowCommand;

    @Inject
    public CLIInitializer(IAppCommand appCommand, UnionCommand unionCommand, BitShowCommand bitShowCommand){
        this.appCommand = appCommand;
        this.unionCommand = unionCommand;
        this.bitShowCommand = bitShowCommand;
    }

    public CommandLine initialize()
    {
        CommandLine commandLine = new CommandLine(appCommand);

        commandLine.addSubcommand(CommandLine.HelpCommand.class);
        commandLine.addSubcommand("union", unionCommand);
        commandLine.addSubcommand("bitshow", bitShowCommand);

        return commandLine;
    }
}
