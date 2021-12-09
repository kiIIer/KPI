package Main.Tools;

/**
 * Just two Integers. Used in Delegate to pass 2 params in it. DTO.
 */
public class TwoIntegers
{
    public final Integer a;
    public final Integer b;

    /**
     * Creates simple class.
     * @param a first integer to be stored.
     * @param b second integer to be stored.
     */
    public TwoIntegers(Integer a, Integer b)
    {
        this.a = a;
        this.b = b;
    }
}
