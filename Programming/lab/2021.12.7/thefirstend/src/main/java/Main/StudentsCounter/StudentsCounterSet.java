package Main.StudentsCounter;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;

import java.util.Iterator;

public class StudentsCounterSet implements IStudentsCounterSet
{
    @Override
    public int count(IInstitute institute)
    {
        Iterator<IDepartment> iterator = (institute.getDepartments()).iterator();

        int studentsCount = 0;
        while (iterator.hasNext())
        {
            IDepartment department = iterator.next();
            studentsCount += department.getStudents().size();
        }
        return studentsCount;
    }
}
