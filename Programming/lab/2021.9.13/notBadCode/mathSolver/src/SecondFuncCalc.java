
public class SecondFuncCalc {
    public double calculate(SecondFuncParam param) {
        return (9 * (Math.asin(param.a) / Math.cos(Math.sqrt(Math.abs(param.b)))) + Math.pow(2.43, param.d) + Math.log(param.c) );
    }
}
