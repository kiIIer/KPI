package Commands;

import Preparators.IZhegalkinPolynomial;
import Tools.IValidator;
import com.google.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "zhp", description = "Calculates and prints zhegalkin polynomial for provided boolean function")
public class ZhegalkinPolynomialCommand implements IZhegalkinPolynomialCommand
{
    private final IValidator validator;
    private final IZhegalkinPolynomial zhegalkinPolynomial;
    @CommandLine.Option(names = {"-t", "--tuple"}, required = true, description = "Tuple, which represents boolean function")
    String tuple;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Inject
    public ZhegalkinPolynomialCommand(
            IValidator validator,
            IZhegalkinPolynomial zhegalkinPolynomial
    )
    {
        this.validator = validator;
        this.zhegalkinPolynomial = zhegalkinPolynomial;
    }

    @Override
    public Integer call()
    {
        if (!validator.validate(tuple))
        {
            throw new CommandLine.ParameterException(spec.commandLine(), "This aint a tuple!");
        }

        System.out.println(zhegalkinPolynomial.translate(tuple));

        return 0;
    }
}
