package Commands;

import Tools.IEqualer;
import Tools.ISubseter;
import Tools.Set;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "subset", description = "Tells if set1 is subset of set2")
public class SubsetCommand implements Callable<Integer>
{
    private final ISubseter subseter;

    @CommandLine.Spec
    private CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-1", "--first"}, required = true, split = ",", description = "First set which will be used")
    private int[] set1;

    @CommandLine.Option(names = {"-2", "--second"}, required = true, split = ",", description = "Second set which will be used")
    private int[] set2;

    @Inject
    public SubsetCommand(ISubseter subseter)
    {
        this.subseter = subseter;
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

        boolean result = this.subseter.assertSubset(set1, set2);

        System.out.println(result);

        return 0;
    }
}
