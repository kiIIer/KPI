public class F1Calculator implements ICalculator {
    public double calculate(IParameter p) {
        var args = p.getArgs();
        var k = args[0];
        var m = args[1];

        var res = 0.0;

        for (var i = 1.0; i < k + 1; i++) {
            res = res + (Math.sqrt(m * (1 / i)) * Math.sin(m * i));
        }

        return res;
    }
}