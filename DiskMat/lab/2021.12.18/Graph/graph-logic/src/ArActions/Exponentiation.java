package ArActions;

public class Exponentiation implements IExponentiation
{
    @Override
    public double apply(double a, double b)
    {
        return Math.pow(a, b);
    }
}
