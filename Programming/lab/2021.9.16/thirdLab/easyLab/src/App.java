public class App {
    public static void main(String[] args) {
        Calculators calc = new Calculators();
        printForm1(2, 2, calc);
        printForm1(4, 2, calc);
        printForm1(3, 2, calc);
        printForm1(2, 6, calc);
        printForm1(2, 4, calc);
        printForm1(2, -5, calc);
        printForm1(-2, 2, calc);
        
    }
    public static void printForm1(double k, double m, Calculators calc) {
        try {
            System.out.println(calc.firstFormula(k, m));
    
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
    }
}
