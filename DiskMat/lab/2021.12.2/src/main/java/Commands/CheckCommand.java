package Commands;

import Checkers.*;
import Tools.IValidator;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "check", description = "Checks provided boolean function using Post criteria")
public class CheckCommand implements ICheckCommand
{
    private final IValidator validator;
    private final ITOne tOne;
    private final ITZero tZero;
    private final IDually dually;
    private final IMonotonic monotonic;
    private final ILinient linient;
    @CommandLine.Option(names = {"-t", "--tuple"}, required = true, description = "Tuple, which represents boolean function")
    String tuple;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public CheckCommand(
            IValidator validator,
            ITOne tOne,
            ITZero tZero,
            IDually dually,
            IMonotonic monotonic,
            ILinient linient
    )
    {
        this.validator = validator;
        this.tOne = tOne;
        this.tZero = tZero;
        this.dually = dually;
        this.monotonic = monotonic;
        this.linient = linient;
    }

    @Override
    public Integer call()
    {
        if (!validator.validate(tuple))
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "This aint a tuple");
        }

        System.out.printf("T1 %b\n", tOne.check(tuple));
        System.out.printf("T0 %b\n", tZero.check(tuple));
        System.out.printf("Dually %b\n", dually.check(tuple));
        System.out.printf("Monotonic %b\n", monotonic.check(tuple));
        System.out.printf("Linient %b\n", linient.check(tuple));

        return 0;
    }
}
