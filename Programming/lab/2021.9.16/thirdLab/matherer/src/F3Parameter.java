public class F3Parameter implements IParameter {

    private double[] args;

    public F3Parameter(double[] args) {

        this.args = args;
        validate();
    }

    public double[] getArgs() {
        return args;
    }

    private void validate() {
        var argsLen = this.args.length;
        var argsCount = 1;
        if (argsLen != argsCount) {
            throw new IllegalArgumentException(
                    String.format("%d arguments are expected, %d was provided", argsCount, argsLen));
        }

        var e = this.args[0];
        var eMin = 0;
        if (e == eMin) {
            throw new IllegalArgumentException(String.format("%+10.0f must be greater than %d", e, eMin));
        }
    }
}