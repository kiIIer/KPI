package Main.StudentsCounter;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;

import java.util.Iterator;

public class StudentsCounterList implements IStudentsCounterList
{
    @Override
    public int count(IInstitute institute)
    {
        var iterator = (Iterator) ((institute.getDepartments()).iterator());

        int studentsCount = 0;
        while (iterator.hasNext())
        {
            IDepartment department = (IDepartment) iterator.next();
            studentsCount += department.getStudents().size();
        }
        return studentsCount;
    }
}
