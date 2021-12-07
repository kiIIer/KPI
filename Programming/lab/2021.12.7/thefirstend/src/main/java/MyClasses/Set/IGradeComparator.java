package MyClasses.Set;

import MyClasses.Abstract.IStudent;

import java.util.Comparator;

public interface IGradeComparator extends Comparator<IStudent>
{
    @Override
    int compare(IStudent o1, IStudent o2);
}
