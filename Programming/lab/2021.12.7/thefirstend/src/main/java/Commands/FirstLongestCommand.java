package Commands;

import Main.FileWorker.IFirstLongestStringFinder;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "first-longest-string", description = "Finds first longest string in provided file")
public class FirstLongestCommand implements IFirstLongestCommand
{
    private final IFirstLongestStringFinder firstLongestStringFinder;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-f", "--filename"}, required = true, description = "Filename of a file to be used in reading.")
    String filename;

    @Inject
    public FirstLongestCommand(
            IFirstLongestStringFinder firstLongestStringFinder
    )
    {
        this.firstLongestStringFinder = firstLongestStringFinder;
    }

    @Override
    public Integer call() throws CommandLine.ParameterException
    {
        try
        {
            System.out.println(firstLongestStringFinder.find(filename));
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return CommandLine.ExitCode.OK;
    }
}
