package Commands;

import Tools.IComplementer;
import Tools.Set;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "complement", description = "Calculates complement of the provided set")
public class ComplementCommand implements Callable<Integer>
{

    private final IComplementer complementer;

    @CommandLine.Spec
    private CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-s", "--set"}, required = true, split = ",", description = "Set which will be used")
    private int[] set;

    @CommandLine.Option(names = {"-n", "--number"}, description = "Shows number representation of the resulting set", defaultValue = "false")
    boolean isNumber;

    @CommandLine.Option(names = {"-b", "--binary"}, description = "Shows binary representation of the resulting set", defaultValue = "false")
    boolean isBinary;

    @CommandLine.Option(names = {"-a", "--array"}, description = "Shows set representation of the resulting set", defaultValue = "true")
    boolean isArray;

    @Inject
    public ComplementCommand(IComplementer complementer)
    {
        this.complementer = complementer;
    }

    @Override
    public Integer call() throws Exception
    {
        Set set = new Set(this.set);

        if (set.invalidNumbers.length != 0)
        {
            throw new CommandLine.ParameterException(this.spec.commandLine(), "Provided set contains following invalid elements: " + Arrays.toString(set.invalidNumbers));
        }

        Set result = complementer.calculate(set);

        if (isArray)
        {
            System.out.println(Arrays.toString(result.elements));
        }
        if (isBinary)
        {
            System.out.println(String.format("%8s", Integer.toBinaryString((byte)(result.binary) & 0xFF)).replace(' ', '0'));
        }
        if (isNumber)
        {
            System.out.println(result.binary);
        }

        return 0;
    }
}
