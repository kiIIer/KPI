package Commands;

import Preparators.ICDNF;
import Tools.IValidator;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "cdnf", description = "Calculates cdnf for provided function and prints it")
public class CDNFCommand implements ICDNFCommand
{
    private final IValidator validator;
    private final ICDNF cdnf;
    @CommandLine.Option(names = {"-t", "--tuple"}, required = true, description = "Tuple, which represents boolean function")
    String tuple;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public CDNFCommand(
            IValidator validator,
            ICDNF cdnf
    )
    {
        this.validator = validator;
        this.cdnf = cdnf;
    }

    @Override
    public Integer call()
    {
        if (!validator.validate(tuple))
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "This aint a tuple");
        }

        System.out.println(cdnf.translate(tuple));

        return 0;
    }
}
