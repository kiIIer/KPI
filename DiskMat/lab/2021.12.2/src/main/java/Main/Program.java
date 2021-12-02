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
    public void execute(String[] args)
    {
        CommandLine cli = cliBuilder.build();

        int exitCode = cli.execute(args);
    }
}
