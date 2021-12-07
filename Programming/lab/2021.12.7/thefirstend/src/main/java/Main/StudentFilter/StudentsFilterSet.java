package Main.StudentFilter;

import Main.Tools.Compare;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import MyClasses.Set.*;
import com.google.inject.Inject;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentsFilterSet implements IStudentsFilterSet
{
    private final IGradeComparator gradeComparator;

    @Inject
    public StudentsFilterSet(
            IGradeComparator gradeComparator
    )
    {

        this.gradeComparator = gradeComparator;
    }

    @Override
    public Collection<IStudent> get(Iterator<IStudent> iterator, int grade, int compareType)
    {
        Set<IStudent> best = new TreeSet<>(gradeComparator);
        while (iterator.hasNext())
        {
            IStudent student = iterator.next();
            if (compare(student, grade, compareType))
            {
                best.add(student);
            }
        }

        return best;
    }

    private boolean compare(IStudent compareWho, int grade, int compareType)
    {
        Student compareTo = new Student();
        compareTo.setGrade(grade);

        if ((compareType & Compare.less) == Compare.less)
        {
            if (this.gradeComparator.compare(compareWho, compareTo) < 0)
            {
                return true;
            }
        }
        if ((compareType & Compare.equal) == Compare.equal)
        {
            if (this.gradeComparator.compare(compareWho, compareTo) == 0)
            {
                return true;
            }
        }
        if ((compareType & Compare.greater) == Compare.greater)
        {
            if (this.gradeComparator.compare(compareWho, compareTo) > 0)
            {
                return true;
            }
        }
        return false;
    }
}
