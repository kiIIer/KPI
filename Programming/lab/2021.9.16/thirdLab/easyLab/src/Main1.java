public class Main1{
    public static void main(String[] args) {
        printOutput(2, 3);
    }
    static void printOutput(double a, double b) {
        try{
            calculate(a, b);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    static void calculate(double a, double b) {
        if(a<0){
            throw new IllegalArgumentException("Check odz!");
        }
        double res = a+b;
        System.out.println(res);
    }
}