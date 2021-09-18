
public class App {
    public static void main(String[] args) {
        double[] fargs = {2, 5};

        var param = new FirstFuncParam(fargs);
        var calc = new FirstFormula();
        var result = calc.calculate(param);

        System.out.println(result);

        double[] f2args = {1, 10};

        var param2 = new SecondFuncParam(f2args);
        var calc2 = new SecondFormula();
        result = calc2.calculate(param2);

        System.out.println(result);

        double f3 = 0.000000000000001;

        var param3 = new ThirdFuncParam(f3);
        var calc3 = new ThirdFormula();
        result = calc3.calculate(param3);

        System.out.println(result);

    }
}
