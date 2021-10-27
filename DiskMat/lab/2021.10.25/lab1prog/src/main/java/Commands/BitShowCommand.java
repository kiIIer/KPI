package Commands;

import Tools.IBitTranslator;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.concurrent.Callable;
@CommandLine.Command(name = "bitshow", description = "Shows bit representation for input sets")
public class BitShowCommand implements Callable<Integer>
{
    private final IBitTranslator bitTranslator;
    @CommandLine.ParentCommand
    private AppCommand parent;

    @CommandLine.Option(names = {"-s", "--set"}, split = ",", description = "Set which will be presented as chosen.")
    int[] set;

    @CommandLine.Option(names = {"-n", "--number"}, description = "Shows number representation of provided set", defaultValue = "false")
    boolean isNumber;

    @CommandLine.Option(names = {"-b", "--bit"}, description = "Shows bit representation of provided set", defaultValue = "true")
    boolean isBit;

    @CommandLine.Option(names = {"-a", "--array"}, description = "Shows array representation of provided set", defaultValue = "false")
    boolean isArray;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public BitShowCommand(IBitTranslator bitTranslator){

        this.bitTranslator = bitTranslator;
    }

    @Override
    public Integer call() throws Exception
    {
        if(set == null){
            throw new CommandLine.ParameterException(spec.commandLine(), "Please provide a set!");
        }
        if(isBit){
            System.out.println(bitTranslator.bitToBitString(bitTranslator.toBit(set)));
        }
        if(isArray){
            System.out.println(Arrays.toString(set));
        }
        if(isNumber){
            System.out.println(bitTranslator.toBit(set));
        }
        return 0;
    }
}
