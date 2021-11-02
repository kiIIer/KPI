import com.google.inject.Inject;
import picocli.CommandLine;

public class Program implements IProgram
{
    private final ICLIInitializer icliInitializer;

    @Inject
    public Program(ICLIInitializer icliInitializer)
    {
        this.icliInitializer = icliInitializer;
    }

    @Override
    public void execute(String[] args)
    {
        CommandLine commandLine = icliInitializer.initialize();

        int exitCode = commandLine.execute(args);

        System.exit(exitCode);
    }
}
