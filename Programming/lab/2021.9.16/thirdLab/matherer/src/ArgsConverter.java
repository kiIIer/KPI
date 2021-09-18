public class ArgsConverter {
    public double[] convert(String[] args) {
        var numbers = new double[args.length];

        for (int i = 0; i < args.length; i++) {
            numbers[i] = Double.parseDouble(args[i]);
        }

        return numbers;
    }
}