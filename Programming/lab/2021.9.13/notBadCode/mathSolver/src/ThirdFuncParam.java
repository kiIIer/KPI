
public class ThirdFuncParam {

    double a;
    double b;
    double c;
    double d;

    public ThirdFuncParam(String[] args) {
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);
        d = Double.parseDouble(args[3]);
        
        if (b == 0 || a == 0) {
            throw new IllegalArgumentException();
        }
        if ((Math.cos(c) + Math.pow(Math.E, d)) < 0 ) {
            throw new IllegalArgumentException();
        }

    }
}