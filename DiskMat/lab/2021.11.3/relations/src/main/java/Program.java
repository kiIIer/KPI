import com.google.inject.Inject;

public class Program implements IProgram
{

    private final ICLIBuilder cliBuilder;

    @Inject
    public Program(ICLIBuilder cliBuilder)
    {
        this.cliBuilder = cliBuilder;
    }

    @Override
    public void run(String[] args)
    {
        var commandLine = cliBuilder.build();

        int exitCode = commandLine.execute(args);

        System.exit(exitCode);
    }
}
