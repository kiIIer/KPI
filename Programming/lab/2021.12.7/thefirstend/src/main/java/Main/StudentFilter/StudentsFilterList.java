package Main.StudentFilter;

import MyClasses.Abstract.IStudent;
import MyClasses.Set.IMyComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class StudentsFilterList implements IStudentsFilterList
{
    @Override
    public Collection<IStudent> get(Iterator<IStudent> iterator, Function<Integer, Boolean> comparator)
    {
        List<IStudent> best = new ArrayList<IStudent>();
        while (iterator.hasNext())
        {
            IStudent student = iterator.next();
            if (comparator.apply(student.getGrade()))
            {
                best.add(student);
            }
        }
        return best;
    }
}

