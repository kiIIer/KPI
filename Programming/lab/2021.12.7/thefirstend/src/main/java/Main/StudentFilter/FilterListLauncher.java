package Main.StudentFilter;

import Main.Tools.FilterSettings;
import Main.Tools.ComparisonType;
import Main.Tools.TwoIntegers;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;

import java.util.*;
import java.util.function.Function;

public class FilterListLauncher implements IFilterListLauncher
{
    private final IStudentsFilterList studentsFilter;
    private static final Map<ComparisonType, Function<TwoIntegers, Boolean>> delegates;

    static
    {
        delegates = new HashMap<>();

        delegates.put(ComparisonType.EQUAL, (TwoIntegers integers) -> Objects.equals(integers.a, integers.b));
        delegates.put(ComparisonType.LESS, (TwoIntegers integers) -> integers.a < integers.b);
        delegates.put(ComparisonType.GREATER, (TwoIntegers integers) -> integers.a > integers.b);
        delegates.put(ComparisonType.LESSEQUAL, (TwoIntegers integers) -> integers.a <= integers.b);
        delegates.put(ComparisonType.GREATEREQUAL, (TwoIntegers integers) -> integers.a >= integers.b);
    }

    @Inject
    public FilterListLauncher(IStudentsFilterList studentsFilter)
    {
        this.studentsFilter = studentsFilter;
    }

    public Collection<IStudent> launch(IInstitute institute, FilterSettings settings)
    {
        Function<Integer, Boolean> comparator = getDelegate(settings.getSearchType(), settings.getGrade());

        return studentsFilter.get(institute.getStudentsIterator(), comparator);
    }

    private Function<Integer, Boolean> getDelegate(ComparisonType comparisonType, int compare)
    {
        Function<TwoIntegers, Boolean> delegate = delegates.get(comparisonType);
        return (Integer grade) ->
        {
            return delegate.apply(new TwoIntegers(grade, compare));
        };
    }
}
