package Commands;

import Tools.IIntToHexer;
import Tools.IntToHexer;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "hex", description = "Converts provided integer into hex string")
public class HexCommand implements Callable<Integer>
{
    private final IIntToHexer intToHexer;
    @CommandLine.Option(names = {"-n", "--number"}, required = true, description = "Integer to be used in conversion")
    int number;

    @Inject
    public HexCommand(IIntToHexer intToHexer)
    {
        this.intToHexer = intToHexer;
    }

    @Override
    public Integer call() throws Exception
    {
        String hex = intToHexer.convert(number);

        System.out.println(hex);
        return 0;
    }
}
