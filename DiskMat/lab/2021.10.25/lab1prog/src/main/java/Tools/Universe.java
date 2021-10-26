package Tools;

public enum Universe
{
    ONE(1),
    TWO(1<<1),
    THREE(1<<2),
    FOUR(1<<3),
    FIVE(1<<4),
    SIX(1<<5),
    SEVEN(1<<6),
    EIGHT(1<<7);

    private final int bitFlag;

    private Universe(int bitFlag)
    {
        this.bitFlag = bitFlag;
    }

    public int getBitFlag()
    {
        return bitFlag;
    }
}
