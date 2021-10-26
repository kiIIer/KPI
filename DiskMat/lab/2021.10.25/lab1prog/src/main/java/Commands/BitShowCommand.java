package Commands;

import Tools.IBitTranslator;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.concurrent.Callable;
@CommandLine.Command(name = "bitshow", description = "Shows bit representation for input sets")
public class BitShowCommand implements Callable<Integer>
{
    private final IBitTranslator bitTranslator;
    @CommandLine.ParentCommand
    private AppCommand parent;

    @Inject
    public BitShowCommand(IBitTranslator bitTranslator){

        this.bitTranslator = bitTranslator;
    }

    @Override
    public Integer call() throws Exception
    {
        System.out.println(bitTranslator.toBit(parent.set1));
        System.out.println(bitTranslator.toBit(parent.set2));
        return 0;
    }
}
