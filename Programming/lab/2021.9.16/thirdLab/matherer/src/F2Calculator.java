public class F2Calculator implements ICalculator {
    public double calculate(IParameter p) {
        var args = p.getArgs();
        var t = args[0];
        var i = args[1];

        var res = 0.0;

        if (i == 1) {
            res = Math.sqrt(t);
        } else if (i == 2) {
            res = (1 / Math.sqrt(t));
        } else {
            for (double k = 1; k < i + 1; k++) {
                res = res + (k * t);
            }
        }
        return res;
    }
}