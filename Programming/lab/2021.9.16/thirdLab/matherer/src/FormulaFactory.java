import java.util.Arrays;

public class FormulaFactory {
    private final IParameter parameter;
    private final ICalculator calculator;

    public IParameter getParameter() {
        return parameter;
    }

    public ICalculator getCalculator() {
        return calculator;
    }

    public FormulaFactory(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided");
        }

        var parameterArgs = Arrays.copyOfRange(args, 1, args.length);

        var argsConverter = new ArgsConverter();
        var numbers = argsConverter.convert(parameterArgs);

        var formulaName = args[0];
        switch (formulaName) {

            case "F1": {
                this.parameter = new F1Parameter(numbers);
                this.calculator = new F1Calculator();
                return;
            }
            case "F2": {
                this.parameter = new F2Parameter(numbers);
                this.calculator = new F2Calculator();
                return;
            }
            case "F3": {
                this.parameter = new F3Parameter(numbers);
                this.calculator = new F3Calculator();
                return;
            }

            default: {
                throw new IllegalArgumentException("Unsupported formula");
            }
        }
    }
}