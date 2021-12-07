package Main.Finder;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;

import java.util.Iterator;

public class FinderList implements IFinderList
{
    @Override
    public IDepartment findMaxStudentDepartment(IInstitute institute)
    {
        IDepartment department = null;
        Iterator i = institute.getDepartments().iterator();
        while (i.hasNext())
        {
            Object o = i.next();
            if (!(o instanceof IDepartment))
            {
                continue;
            }
            if (department == null)
            {
                department = (IDepartment) o;
                continue;
            }

            IDepartment currentDepartment = (IDepartment) o;
            if (department.getStudents().size() < currentDepartment.getStudents().size())
            {
                department = currentDepartment;
            }

        }
        return department;
    }
}
