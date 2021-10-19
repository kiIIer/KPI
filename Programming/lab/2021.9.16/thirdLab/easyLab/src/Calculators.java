public class Calculators {
    public double firstFormula(double k, double s) {
        double result = 0;

        if (k >= 35 || k < 1 || s < 0) {
            throw new IllegalArgumentException("Plz check your odz!");
        }
        for (double i = 1; i < k; i++) {
            result = result + Math.log10(Math.sqrt(s * (1 / i * i)));
        }

        return result;
    }
}
