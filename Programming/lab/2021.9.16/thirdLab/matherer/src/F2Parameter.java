public class F2Parameter implements IParameter {

    private double[] args;

    public F2Parameter(double[] args) {

        this.args = args;
        validate();
    }

    public double[] getArgs() {
        return args;
    }

    private void validate() {
        var argsLen = this.args.length;
        var argsCount = 2;
        if (argsLen != argsCount) {
            throw new IllegalArgumentException(
                    String.format("%d arguments are expected, %d was provided", argsCount, argsLen));
        }

        var t = this.args[0];
        var kMin = 0;
        if (t < kMin) {
            throw new IllegalArgumentException(String.format("%+10.0f must be greater than %d", t, kMin));
        }

        var i = this.args[1];
        var iMin = 1;
        if (i < iMin) {
            throw new IllegalArgumentException(String.format("'k' must be greater than %d", iMin));
        }
    }
}