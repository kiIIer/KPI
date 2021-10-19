public class F3Calculator implements ICalculator {
    public double Calculate(IParameter parameter){
        return Calculate((F3Parameter) parameter);
    }
    private static double Calculate(F3Parameter parameter){
        var e = parameter.getE();

        var res = 0.0;

        for (double i = 1; true; i++) {
            double param = 1 / (Math.pow(i, 2));
            if (param < e) {
                break;
            }
            res = res + param;
        }
        return res;
    }
}

