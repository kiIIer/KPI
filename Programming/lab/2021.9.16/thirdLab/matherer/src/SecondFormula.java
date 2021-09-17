public class SecondFormula {

    public double calculate(SecondFuncParam p) {
        double res = 0;
       if (p.i == 1) {
           res = Math.sqrt(p.t);
       } else if(p.i == 2) {
           res = (1/Math.sqrt(p.t));
       } else {
           for(double k = 1; k < p.i+1; k++){
               res = res + (k * p.t);
           }
       }
        return res;
    }
}