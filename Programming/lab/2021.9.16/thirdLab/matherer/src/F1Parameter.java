public class F1Parameter implements IParameter {

    private double[] args;

    public F1Parameter(double[] args) {

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

        var m = this.args[0];
        var mMin = 0;
        if (m < mMin) {
            throw new IllegalArgumentException(String.format("%+10.0f must be greater than %d", m, mMin));
        }

        var k = this.args[1];
        var kMin = 1;
        var kMax = 30;
        if (k < kMin || k > kMax) {
            throw new IllegalArgumentException(String.format("'k' must be in range [%d; %d]", kMin, kMax));
        }
    }
}