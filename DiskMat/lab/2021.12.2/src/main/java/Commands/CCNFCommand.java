package Commands;

import Preparators.ICCNF;
import Tools.IValidator;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "ccnf", description = "Calculates ccnf for provided boolean function and prints it")
public class CCNFCommand implements ICCNFCommand
{
    private final IValidator validator;
    private final ICCNF ccnf;
    @CommandLine.Option(names = {"-t", "--tuple"}, required = true, description = "Tuple, which represents boolean function")
    String tuple;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public CCNFCommand(
            IValidator validator,
            ICCNF ccnf
    )
    {
        this.validator = validator;
        this.ccnf = ccnf;
    }

    @Override
    public Integer call()
    {
        if (!validator.validate(tuple))
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "This aint a tuple");
        }

        System.out.println(ccnf.translate(tuple));

        return 0;
    }
}
