package Main;

import com.google.inject.Inject;
import picocli.CommandLine;

public class Program implements IProgram
{
    private final ICLIBuilder cliBuilder;

    @Inject
    public Program(
            ICLIBuilder cliBuilder
    )
    {
        this.cliBuilder = cliBuilder;
    }

    @Override
    public void execute(String[] args) throws Exception
    {
        CommandLine commandLine = cliBuilder.build();
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}
