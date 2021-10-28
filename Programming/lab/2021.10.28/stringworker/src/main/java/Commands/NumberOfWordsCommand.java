package Commands;

import Tools.INumberOfWordser;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "number-of-words", description = "Calculates number of words in provided string")
public class NumberOfWordsCommand implements Callable<Integer>
{
    private final INumberOfWordser numberOfWordser;
    @CommandLine.Option(names = {"-s", "--string"}, required = true, description = "String containing words to be counted")
    private String string;

    @Inject
    public NumberOfWordsCommand(INumberOfWordser numberOfWordser)
    {
        this.numberOfWordser = numberOfWordser;
    }

    @Override
    public Integer call() throws Exception
    {
        long number = numberOfWordser.calculate(string);

        System.out.println(number);

        return 0;
    }
}
