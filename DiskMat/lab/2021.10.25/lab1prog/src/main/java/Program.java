import picocli.CommandLine;

import javax.inject.Inject;

public class Program implements IProgram
{
    private final ICLIInitializer cliInitializer;

    @Inject
    public Program(ICLIInitializer cliInitializer)
    {
        this.cliInitializer = cliInitializer;
    }

    public void run(String[] args)
    {
        CommandLine commandLine = cliInitializer.initialize();

        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}
