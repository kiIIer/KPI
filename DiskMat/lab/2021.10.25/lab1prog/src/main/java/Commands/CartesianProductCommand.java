package Commands;

import Tools.ICartesianProducter;
import Tools.Set;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "cartesian-product", description = "Calculates cartesian product of provided sets")
public class CartesianProductCommand implements Callable<Integer>
{
    private final ICartesianProducter cartesianProducter;
    @CommandLine.Spec
    private CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-1", "--first"}, required = true, split = ",", description = "First set which will be used")
    private int[] set1;

    @CommandLine.Option(names = {"-2", "--second"}, required = true, split = ",", description = "Second set which will be used")
    private int[] set2;

    @Inject
    public CartesianProductCommand(ICartesianProducter cartesianProducter)
    {
        this.cartesianProducter = cartesianProducter;
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

        int[][] result = cartesianProducter.calculate(set1, set2);

        String out = "[ ";
        for (int[] pair : result)
        {
            out = out + Arrays.toString(pair) + " ";
        }
        out = out + "]";

        System.out.println(out);
        return 0;
    }
}
