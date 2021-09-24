public class F2Calculator implements ICalculator {
    public double Calculate(IParameter parameter){
        return Calculate((F2Parameter) parameter);
    }
    private static double Calculate(F2Parameter parameter){
        var i = parameter.getI();
        var t = parameter.getT();

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

