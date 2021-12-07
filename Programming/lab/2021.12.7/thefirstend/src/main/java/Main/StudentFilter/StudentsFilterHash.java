package Main.StudentFilter;

import MyClasses.Abstract.IStudent;
import MyClasses.Hash.*;
import com.google.inject.Inject;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StudentsFilterHash implements IStudentsFilterHash
{
    private final IMyAdvancedComparator comparator;

    @Inject
    public StudentsFilterHash(IMyAdvancedComparator comparator)
    {
        this.comparator = comparator;
    }

    @Override
    public Collection<IStudent> get(Iterator<IStudent> iterator, int grade, ComparatorConfiguration configuration)
    {
        Set<IStudent> best = new HashSet<>();
        while (iterator.hasNext())
        {
            IStudent student = iterator.next();
            if (comparator.compare(student, grade, configuration))
            {
                best.add(student);
            }
        }

        return best;
    }
}
