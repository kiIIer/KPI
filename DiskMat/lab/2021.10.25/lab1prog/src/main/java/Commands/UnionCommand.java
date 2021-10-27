package Commands;

import Tools.BitTranslator;
import Tools.IUnioner;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "union", description = "Calculates the union of provided sets.")
public class UnionCommand implements Callable<Integer>
{
    private final BitTranslator bitTranslator;
    private final IUnioner unioner;

    @CommandLine.ParentCommand
    private AppCommand parent;

    @Inject
    public UnionCommand(BitTranslator bitTranslator, IUnioner unioner)
    {
        this.bitTranslator = bitTranslator;
        this.unioner = unioner;
    }

    @Override
    public Integer call() throws Exception
    {
        int bitSet1 = bitTranslator.toBit(parent.set1);
        int bitSet2 = bitTranslator.toBit(parent.set2);
        String bitCode = bitTranslator.bitToBitString(unioner.calculate(bitSet1, bitSet2));
        System.out.println(bitCode);
        System.out.println(Arrays.toString(bitTranslator.bitToArray(unioner.calculate(bitSet1, bitSet2))));
        System.out.println("FOR THE UNION");
        return 0;
    }
}
