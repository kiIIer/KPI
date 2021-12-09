package Main.StudentFilter;

import Main.Tools.Compare;
import Main.Tools.FilterSettings;
import Main.Tools.ComparisonType;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class FilterTreeLauncher implements IFilterTreeLauncher
{
    private static final Map<ComparisonType, Integer> searchType;

    static
    {
        searchType = new TreeMap<>();

        searchType.put(ComparisonType.EQUAL, Compare.equal);
        searchType.put(ComparisonType.LESS, Compare.less);
        searchType.put(ComparisonType.GREATER, Compare.greater);
        searchType.put(ComparisonType.GREATEREQUAL, Compare.equal | Compare.greater);
        searchType.put(ComparisonType.LESSEQUAL, Compare.equal | Compare.less);
    }

    private final IStudentsFilterSet studentsFilter;

    @Inject
    public FilterTreeLauncher(IStudentsFilterSet studentsFilter)
    {

        this.studentsFilter = studentsFilter;
    }

    @Override
    public Collection<IStudent> launch(IInstitute institute, FilterSettings settings)
    {
        return studentsFilter.get(institute.getStudentsIterator(), settings.getGrade(), searchType.get(settings.getSearchType()));
    }
}
