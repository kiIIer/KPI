public class F2Parameter implements IParameter {
    private final double i;
    private final double t;

    public double getI() {
        return this.i;
    }

    public double getT() {
        return this.t;
    }

    public F2Parameter(double i, double t) {
        var tMin = 0;
        if (t < tMin) {
            throw new IllegalArgumentException(String.format("%+10.0f must be greater than %d", t, tMin));
        }

        var iMin = 1;
        if (i < iMin) {
            throw new IllegalArgumentException(String.format("'k' must be greater than %d", iMin));
        }
        this.i = i;
        this.t = t;
 
    }
}
