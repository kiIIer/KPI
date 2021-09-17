public class FirstFormula {

    public double calculate(FirstFuncParam p) {
        double res = 0;
        for (double i = 1; i < p.k + 1; i++) {
            res = res + (Math.sqrt(p.m * (1 / i)) * Math.sin(p.m * i));
        }
        return res;
    }
}