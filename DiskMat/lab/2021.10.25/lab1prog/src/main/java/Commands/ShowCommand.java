package Commands;

import Tools.*;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "show", description = "Shows representations for the provided set")
public class ShowCommand implements Callable<Integer>
{
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-s", "--set"}, required = true, split = ",", description = "Set which will be used.")
    private int[] set;

    @CommandLine.Option(names = {"-n", "--number"}, description = "Shows number representation of the provided set", defaultValue = "false")
    boolean isNumber;

    @CommandLine.Option(names = {"-b", "--binary"}, description = "Shows binary representation of the provided set", defaultValue = "true")
    boolean isBinary;

    @CommandLine.Option(names = {"-a", "--array"}, description = "Shows set representation of the provided set", defaultValue = "false")
    boolean isArray;


    @Inject
    public ShowCommand()
    {
    }

    @Override
    public Integer call() throws Exception
    {
        Set set = new Set(this.set);

        if (set.invalidNumbers.length != 0)
        {
            throw new CommandLine.ParameterException(this.spec.commandLine(), "Provided set contains following invalid numbers: " + Arrays.toString(set.invalidNumbers));
        }

        if (isArray)
        {
            System.out.println(Arrays.toString(set.elements));
        }
        if (isBinary)
        {
            System.out.println(Integer.toBinaryString(set.binary));
        }
        if (isNumber)
        {
            System.out.println(set.binary);
        }

        return 0;
    }
}
