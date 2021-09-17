public class ThirdFormula {

    public double calculate(ThirdFuncParam p) {
        double res = 0;
    for(double i = 1; true; i++) {
        double param = 1/(Math.pow(i, 2));
        if(param < p.e){
            break;
        }
        res = res + param;
    }
        return res;
    }
}