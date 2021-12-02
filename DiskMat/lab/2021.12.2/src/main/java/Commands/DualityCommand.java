package Commands;

import Preparators.IDuality;
import Tools.IValidator;
import com.google.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "dually", description = "Calculates and prints dually function to the provided one.")
public class DualityCommand implements IDualityCommand
{
    private final IValidator validator;
    private final IDuality duality;
    @CommandLine.Option(names = {"-t", "--tuple"}, required = true, description = "Tuple, which represents boolean function")
    String tuple;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public DualityCommand(
            IValidator validator,
            IDuality duality
    )
    {
        this.validator = validator;
        this.duality = duality;
    }

    @Override
    public Integer call()
    {
        if (!validator.validate(tuple))
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "This aint a tuple");
        }

        System.out.println(duality.translate(tuple));

        return 0;
    }
}
