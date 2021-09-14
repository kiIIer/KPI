
public class FirstFuncCalc {
    public double calculate(FirstFuncParam param) {
        return (Math.sqrt(Math.abs(Math.sin(param.a) - (4 * Math.log(param.b)) / Math.pow(param.c, param.d))));
    }
}
