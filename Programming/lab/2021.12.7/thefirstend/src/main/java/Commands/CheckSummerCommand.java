package Commands;

import Main.FileWorker.CheckSummer;
import Main.FileWorker.ICheckSummer;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "check-sum", description = "Calculates and prints check sum of file.")
public class CheckSummerCommand implements ICheckSummerCommand
{
    private final ICheckSummer checkSummer;
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-f", "--filename"}, required = true, description = "Filename of a file to be used.")
    String filename;

    @Inject
    public CheckSummerCommand(
            ICheckSummer checkSummer
    )
    {
        this.checkSummer = checkSummer;
    }

    @Override
    public Integer call() throws Exception
    {
        try
        {
            System.out.println(checkSummer.checkSum(filename));
        } catch (IOException e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return 0;
    }
}
