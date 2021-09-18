public class App {
    public static void main(String[] args) {
        FormulaFactory factory;

        try {
            factory = new FormulaFactory(args);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            System.out.println(message);
            return;
        }

        var parameter = factory.getParameter();
        var calculator = factory.getCalculator();
        var result = calculator.calculate(parameter);

        System.out.println(result);
    }
}