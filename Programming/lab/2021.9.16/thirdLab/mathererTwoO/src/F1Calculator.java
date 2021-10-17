public class F1Calculator implements ICalculator {
    public double Calculate(IParameter parameter){
        return Calculate((F1Parameter) parameter);
    }
    private static double Calculate(F1Parameter parameter){
        var k = parameter.getK();
        var m = parameter.getM();

        var res = 0.0;

        for (var i = 1.0; i < k + 1; i++) {
            res = res + (Math.sqrt(m * (1 / i)) * Math.sin(m * i));
        }

        return res;
    }
}

