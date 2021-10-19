public class F1Parameter implements IParameter{
    private final double k;
    private final double m;

    public double getK() {
        return this.k;
    }

    public double getM() {
        return this.m;
    }

    public F1Parameter(double k, double m) {
        var mMin = 0;
        if (m < mMin) {
            throw new IllegalArgumentException(String.format("%+10.0f must be greater than %d", m, mMin));
        }

        var kMin = 1;
        var kMax = 30;
        if (k < kMin || k > kMax) {
            throw new IllegalArgumentException(String.format("'k' must be in range [%d; %d]", kMin, kMax));
        }
        this.k = k;
        this.m = m;
    }
}
