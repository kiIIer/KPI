public class F3Calculator implements ICalculator {
    public double calculate(IParameter p) {
        var args = p.getArgs();
        var e = args[0];

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