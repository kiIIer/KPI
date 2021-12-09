package Main.Tools;

/**
 * Filter settings. DTO.
 */
public class FilterSettings
{
    private final ComparisonType comparisonType;
    private final int grade;

    /**
     * Getter.
     * @return Returns search type which will be used.
     */
    public ComparisonType getSearchType()
    {
        return comparisonType;
    }

    /**
     * Getter.
     * @return Returns grade to compare to.
     */
    public int getGrade()
    {
        return grade;
    }

    /**
     * Constuctor to creaate this DTO. Does not do anything special.
     * @param comparisonType Comparison type to be stored.
     * @param grade Grade to be stored.
     */
    public FilterSettings(ComparisonType comparisonType, int grade)
    {
        this.comparisonType = comparisonType;
        this.grade = grade;
    }

}
