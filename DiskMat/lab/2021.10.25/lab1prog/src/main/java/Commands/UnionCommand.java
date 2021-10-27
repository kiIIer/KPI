package Commands;

import Commands.AppCommand;
import Tools.BitTranslator;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "union", description = "Calculates the union of sets.")
public class UnionCommand implements Callable<Integer>
{
    private final BitTranslator bitTranslator;
    @CommandLine.ParentCommand
    private AppCommand parent;

    @Inject
    public UnionCommand(BitTranslator bitTranslator){
        this.bitTranslator = bitTranslator;
    }

    @Override
    public Integer call() throws Exception
    {
        int bitSet1 = bitTranslator.toBit(parent.set1);
        int bitSet2 = bitTranslator.toBit(parent.set2);

        int result = bitSet1 | bitSet2;

        System.out.println(bitTranslator.bitToBitString(result));
        System.out.println("FOR THE UNION");
        return 0;
    }
}
