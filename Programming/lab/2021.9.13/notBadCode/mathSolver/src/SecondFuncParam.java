
public class SecondFuncParam {

    double a;
    double b;
    double c;
    double d;

    public SecondFuncParam(String[] args) {
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);
        d = Double.parseDouble(args[3]);

        if(a < -1 || a > 1) {
            throw new IllegalArgumentException();
        }
        if(c <= 0) {
            throw new IllegalArgumentException();
        }
        if (Math.cos(Math.sqrt(Math.abs(b))) == 0) {
            throw new IllegalArgumentException();
        }

    }
}