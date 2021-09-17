/**
 * Lab 03, Task 1 example
 *
 * @author Bukasov
 */
public class Task1 {

    /**
     * Entry point. Tests the method {@code axx(a,x)} by calling the helper
     * method {@code printResults(a,x)} few times with different arguments.
     *
     * @param a the parameter of the function {@code axx(a,x)}.
     * @param x the argument of the function {@code axx(a,x)}.
     */
    public static void main(String[] args) {
        printResults(0, 0);
        printResults(0, 1);
        printResults(1, 0);
        printResults(1, 1);
        printResults(2, 1);
        printResults(1, 2);
        printResults(2, -10);
        printResults(20, 20);
        printResults(21, 21);
        printResults(1, 10);
        printResults(-1, 10);
        printResults(0, Double.MAX_VALUE);
        printResults(1, Double.MAX_VALUE);
        printResults(1, Double.NaN);
    }

    /**
     * Returns the value of the first argument multiplied by the square of the
     * second argument. Special cases:
     * <ul><li>If the first argument is less than 0 or is greater than 20, then
     * exception IllegarArgumentException is thrown.</ul>
     *
     * @param a the parameter of the function.
     * @param x the argument of the function.
     * @return a * x * x.
     * @exception IllegalArgumentException if a&lt;0 or a&gt;20
     */
    public static double axx(double a, double x) {
        if (a < 0 || a > 20) {
            throw new IllegalArgumentException("param a = " + a);
        }
        return a * x * x;
    }

    /**
     * Helper method for printing result of {@code axx(a,x)}.
     *
     * @param a the parameter of the function.
     * @param x the argument of the function.
     */
    static void printResults(double a, double x) {
        System.out.print("a:" + a + " x:" + x + " result:");
        try {
            System.out.println(axx(a, x));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
