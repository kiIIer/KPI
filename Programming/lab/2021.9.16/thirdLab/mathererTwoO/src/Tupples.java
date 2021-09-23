public class Tupples {
    private final IParameterFactory parameterFactory;
    private final ICalculator calculator;
    
    public IParameterFactory getParameterFactory() {
        return this.parameterFactory;
    }

    public ICalculator getCalculator() {
        return this.calculator;
    }
    
    public Tupples(IParameterFactory parameterFactory, ICalculator calculator) {
        this.parameterFactory = parameterFactory;
        this.calculator = calculator;
    }

}
