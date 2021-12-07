package Main.StudentFilter;

import Main.Tools.FilterSettings;
import Main.Tools.SearchType;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import MyClasses.Hash.ComparatorConfiguration;
import com.google.inject.Inject;
import org.checkerframework.checker.units.qual.C;

import java.lang.module.Configuration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FilterHashLauncher implements IFilterHashLauncher
{
    private final static Map<SearchType, ComparatorConfiguration> searchType;

    static
    {
        searchType = new HashMap<>();

        searchType.put(SearchType.EQUAL, new ComparatorConfiguration(0, 0));
        searchType.put(SearchType.LESS, new ComparatorConfiguration(-1, 0));
        searchType.put(SearchType.LESSEQUAL, new ComparatorConfiguration(1, -1));
        searchType.put(SearchType.GREATER, new ComparatorConfiguration(1, 0));
        searchType.put(SearchType.GREATEREQUAL, new ComparatorConfiguration(-1, 1));
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
