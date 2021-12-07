package Main.StudentFilter;

import MyClasses.Abstract.IStudent;
import MyClasses.Set.IMyComparator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public interface IStudentsFilterList
{
    Collection<IStudent> get(Iterator<IStudent> iterator, Function<Integer, Boolean> comparator);
}
