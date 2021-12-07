package Main.Tools;

public class FilterSettings
{
    private final SearchType searchType;
    private final int grade;

    public SearchType getSearchType()
    {
        return searchType;
    }

    public int getGrade()
    {
        return grade;
    }

    public FilterSettings(SearchType searchType, int grade)
    {
        this.searchType = searchType;
        this.grade = grade;
    }

}
