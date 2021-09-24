import java.util.Arrays;
import java.util.Hashtable;

public class App {
    public static void main(String[] args) throws Exception {
        var supportedFormulas = new Hashtable<String, Tupples>();
        supportedFormulas.put("f1", new Tupples(new F1ParameterFactory(), new F1Calculator()));
        supportedFormulas.put("f2", new Tupples(new F2ParameterFactory(), new F2Calculator()));
        supportedFormulas.put("f3", new Tupples(new F3ParameterFactory(), new F3Calculator()));
      
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Please provide arguments!");
            }

            var formulaName = args[0];

            var tupple = supportedFormulas.get(formulaName);

            var parameterFactory = tupple.getParameterFactory();
            var calculator = tupple.getCalculator();

            var cuttedArgs = Arrays.copyOfRange(args, 1, args.length);

            var parameter = parameterFactory.Create(cuttedArgs);
            var result = calculator.Calculate(parameter);
            
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert imput to doubles(");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }
}
