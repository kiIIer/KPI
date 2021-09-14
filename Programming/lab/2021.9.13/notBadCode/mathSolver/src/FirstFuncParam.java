
public class FirstFuncParam {

    double a = Double.NaN;
    double b = Double.NaN;
    double c = Double.NaN;
    double d = Double.NaN;

    public FirstFuncParam(String[] args) {
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);
        d = Double.parseDouble(args[3]);

        if (b <= 0) {
            throw new IllegalArgumentException();
        }
        if (c == 0) {
            throw new IllegalArgumentException();
        }

    }
}