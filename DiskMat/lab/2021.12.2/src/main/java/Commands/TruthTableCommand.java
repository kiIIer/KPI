package Commands;

import Preparators.ITruthTable;
import Tools.IValidator;
import Tools.IWriter;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "truth", description = "This command outputs a truth table for provided boolean function")
public class TruthTableCommand implements ITruthTableCommand
{
    private final IValidator validator;
    private final IWriter writer;
    private final ITruthTable truthTable;
    @CommandLine.Option(names = {"-t", "--tuple"}, required = true, description = "Tuple, which represents boolean function")
    String tuple;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public TruthTableCommand(
            IValidator validator,
            IWriter writer,
            ITruthTable truthTable
    )
    {
        this.validator = validator;
        this.writer = writer;
        this.truthTable = truthTable;
    }

    @Override
    public Integer call()
    {
        if (!validator.validate(tuple))
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "This aint a tuple!");
        }

        try
        {
            writer.write(truthTable.translate(tuple));
        } catch (Exception e)
        {
            throw new CommandLine.ParameterException(spec.commandLine(), e.getMessage());
        }

        return 0;
    }
}
