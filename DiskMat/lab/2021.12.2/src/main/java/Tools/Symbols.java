package Tools;

public final class Symbols
{
    public static final char X = makeX();
    public static final char NOT_X = makeNotX();
    public static final char Y = makeY();
    public static final char NOT_Y = makeNotY();
    public static final char Z = makeZ();
    public static final char NOT_Z = makeNotZ();
    public static final char CONJUNCTION = makeConjunction();
    public static final char DISJUNCTION = makeDisjunction();
    public static final char EXCLUSIVE_DISJUNCTION = makeExclusiveDisjunction();

    private static char makeX()
    {
        return '\u0078';
    }

    private static char makeNotX()
    {
        return '\u1E8B';
    }

    private static char makeY()
    {
        return '\u0079';
    }

    private static char makeNotY()
    {
        return '\u1E8F';
    }

    private static char makeZ()
    {
        return '\u007A';
    }

    private static char makeNotZ()
    {
        return '\u017C';
    }

    private static char makeConjunction()
    {
        return '\u2227';
    }

    private static char makeDisjunction()
    {
        return '\u2228';
    }

    private static char makeExclusiveDisjunction()
    {
        return '\u22BB';
    }
}
