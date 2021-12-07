package MyClasses.Hash;

import MyClasses.Abstract.IDepartment;

import java.util.Comparator;

public interface IStudentsNumberComparator extends Comparator<IDepartment>
{
    int compare(IDepartment o1, IDepartment o2);
}
