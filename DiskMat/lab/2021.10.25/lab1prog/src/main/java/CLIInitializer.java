import com.google.inject.Inject;
import picocli.CommandLine;

public class CLIInitializer implements ICLIInitializer
{
    private final IAppCommand appCommand;

    @Inject
    public CLIInitializer(IAppCommand appCommand){
        this.appCommand = appCommand;
    }

    public CommandLine initialize()
    {
        CommandLine commandLine = new CommandLine(appCommand);



        return commandLine;
    }
}
