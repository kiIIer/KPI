package MyClasses.Hash;

import MyClasses.Abstract.IDepartment;

public class StudentsNumberComparator implements IStudentsNumberComparator
{
    @Override
    public int compare(IDepartment o1, IDepartment o2)
    {
        return Integer.compare(o1.getStudents().size(), o2.getStudents().size());
    }
}
