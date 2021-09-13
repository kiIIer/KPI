
public class Main{
    public static void main(String[] args) {
        double[] params = new double[args.length];
        params = convert(args);
        int num = (int)params[0];
        checkodz(num, params[1], params[2], params[3], params[4]);
        System.out.println( count(num, params[1], params[2], params[3], params[4]));
        
    }
    public static double[] convert(String[] args) {
        double[] params = new double[args.length];
        try {
            for(int i = 0; i < params.length; i++){
                params[i] = Double.parseDouble(args[i]);
            }
        } catch (Exception e) {
            
        }
        return params;
    }
    public static double count(int num, double a, double b, double c, double d) {
        switch (num) {
            case 1: return (Math.sqrt(Math.abs(Math.sin(a)-(4 * Math.log(b)) / Math.pow(c, d))));
            case 2: return (9 * (Math.asin(a) / Math.cos(Math.sqrt(Math.abs(b)))) + Math.pow(2.43, d) + Math.log(c) );
            case 3: return (3 * (Math.log(Math.abs(a/b)) + Math.sqrt(Math.cos(c) + Math.pow(Math.E, d))) );
        }
        return Double.NaN;
    }
    public static void checkodz(int num, double a, double b, double c, double d){
        switch (num) {
            case 1:
                if (b <= 0) {
                    throw new IllegalArgumentException();
                }
                return;
            case 2: 
                if(a < -1 || a > 1) {
                    throw new IllegalArgumentException();
                }
                if(c <= 0) {
                    throw new IllegalArgumentException();
                }
                if (Math.cos(Math.sqrt(Math.abs(b))) == 0) {
                    throw new IllegalArgumentException();
                }
            return;
            case 3:
                if (b == 0 || a == 0) {
                    throw new IllegalArgumentException();
                }
                if ((Math.cos(c) + Math.pow(Math.E, d)) < 0 ) {
                    throw new IllegalArgumentException();
                }
            return;
            default: throw new IllegalArgumentException();
        }
    }
}