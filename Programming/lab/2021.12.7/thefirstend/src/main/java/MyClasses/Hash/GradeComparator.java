package MyClasses.Hash;

import MyClasses.Abstract.IStudent;

import java.util.Comparator;

public class GradeComparator implements IGradeComparator
{

    @Override
    public int compare(IStudent o1, IStudent o2)
    {
        return Integer.compare(o1.getGrade(), o2.getGrade());
    }
}
