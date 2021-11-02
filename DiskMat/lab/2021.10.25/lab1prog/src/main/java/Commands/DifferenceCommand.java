package Commands;

import Tools.IDifferencer;
import Tools.IIntersectioner;
import Tools.Set;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "difference", description = "Calculates the difference of provided sets.")
public class DifferenceCommand implements Callable<Integer>
{
    private final IDifferencer differencer;

    @CommandLine.Spec
    private CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-1", "--first"}, required = true, split = ",", description = "First set which will be used")
    private int[] set1;

    @CommandLine.Option(names = {"-2", "--second"}, required = true, split = ",", description = "Second set which will be used")
    private int[] set2;

    @CommandLine.Option(names = {"-n", "--number"}, description = "Shows number representation of the resulting set", defaultValue = "false")
    boolean isNumber;

    @CommandLine.Option(names = {"-b", "--binary"}, description = "Shows binary representation of the resulting set", defaultValue = "false")
    boolean isBinary;

    @CommandLine.Option(names = {"-a", "--array"}, description = "Shows set representation of the resulting set", defaultValue = "true")
    boolean isArray;

    @Inject
    public DifferenceCommand(IDifferencer differencer)
    {
        this.differencer = differencer;
    }

    @Override
    public Integer call() throws Exception
    {
        Set set1 = new Set(this.set1);
        Set set2 = new Set(this.set2);

        if ((set1.invalidNumbers.length != 0) || (set2.invalidNumbers.length != 0))
        {
            throw new CommandLine.ParameterException(this.spec.commandLine(), "Provided sets contain following invalid elements: " + Arrays.toString(set1.invalidNumbers) + " " + Arrays.toString(set2.invalidNumbers));
        }

        Set result = differencer.calculate(set1, set2);

        if (isArray)
        {
            System.out.println(Arrays.toString(result.elements));
        }
        if (isBinary)
        {
            System.out.println(Integer.toBinaryString(result.binary));
        }
        if (isNumber)
        {
            System.out.println(result.binary);
        }

        return 0;
    }
}
