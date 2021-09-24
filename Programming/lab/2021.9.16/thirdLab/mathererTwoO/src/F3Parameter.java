public class F3Parameter implements IParameter {
    private final double e;

    public double getE() {
        return this.e;
    }

    public F3Parameter(double e) {
        var eMin = 0;
        if (e <= eMin) {
            throw new IllegalArgumentException(String.format("%+10.0f must be greater than %d", e, eMin));
        }

        this.e = e;
 
    }
}
