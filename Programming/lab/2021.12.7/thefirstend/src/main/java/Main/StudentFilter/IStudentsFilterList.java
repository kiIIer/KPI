package Main.StudentFilter;

import MyClasses.Abstract.IStudent;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/**
 * Filters students.
 */
public interface IStudentsFilterList
{
    /**
     * Filters students, using provided Delegate. If execution of it returns true - student passed the filtration.
     *
     * @param iterator   Iterator on students desired to be filtered.
     * @param comparator Delegate, which will be used to determinate whether student passed the filtration.
     * @return Collection of filtered students. ArrayList is inside.
     */
    Collection<IStudent> get(Iterator<IStudent> iterator, Function<Integer, Boolean> comparator);
}
