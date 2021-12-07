package MyClasses.Set;

import MyClasses.Abstract.IDepartment;

import java.util.Comparator;

public interface IStudentsNumberComparator extends Comparator<IDepartment>
{
    @Override
    int compare(IDepartment o1, IDepartment o2);
}
