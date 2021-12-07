package MyClasses.Hash;

import MyClasses.Abstract.IStudent;

public interface IMyAdvancedComparator
{
    boolean compare(IStudent student, int grade, ComparatorConfiguration configuration);
}
