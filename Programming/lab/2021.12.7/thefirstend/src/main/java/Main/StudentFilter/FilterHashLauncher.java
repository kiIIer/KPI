package Main.StudentFilter;

import Main.Tools.FilterSettings;
import Main.Tools.ComparisonType;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import MyClasses.Hash.ComparatorConfiguration;
import com.google.inject.Inject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FilterHashLauncher implements IFilterHashLauncher
{
    private final static Map<ComparisonType, ComparatorConfiguration> searchType;

    static
    {
        searchType = new HashMap<>();

        searchType.put(ComparisonType.EQUAL, new ComparatorConfiguration(0, 0));
        searchType.put(ComparisonType.LESS, new ComparatorConfiguration(-1, 0));
        searchType.put(ComparisonType.LESSEQUAL, new ComparatorConfiguration(1, -1));
        searchType.put(ComparisonType.GREATER, new ComparatorConfiguration(1, 0));
        searchType.put(ComparisonType.GREATEREQUAL, new ComparatorConfiguration(-1, 1));
    }

    private final IStudentsFilterHash studentsFilter;

    @Inject
    public FilterHashLauncher(IStudentsFilterHash studentsFilter)
    {
        this.studentsFilter = studentsFilter;
    }

    @Override
    public Collection<IStudent> launch(IInstitute institute, FilterSettings settings)
    {
        return studentsFilter.get(institute.getStudentsIterator(), settings.getGrade(), searchType.get(settings.getSearchType()));
    }
}
