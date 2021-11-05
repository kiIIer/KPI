package Tools.Checks;

public final class Checks
{
    public static final int none = 0;
    public static final int reflexive = 1 << 0;
    public static final int irreflexive = 1 << 1;
    public static final int symmetric = 1 << 2;
    public static final int antiSymmetric = 1 << 3;
    public static final int asymmetric = 1 << 4;
    public static final int transitive = 1 << 5;
    public static final int antiTransitive = 1 << 6;
    public static final int equivalence = 1 << 7;
    public static final int partialOrder = 1 << 8;
    public static final int strictOrder = 1 << 9;
    public static final int all = none |
            reflexive |
            irreflexive |
            symmetric |
            antiSymmetric |
            asymmetric |
            transitive |
            antiTransitive |
            partialOrder |
            strictOrder |
            equivalence;
}