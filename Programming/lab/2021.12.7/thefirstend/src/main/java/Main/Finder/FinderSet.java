package Main.Finder;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Set.*;
import com.google.inject.Inject;
import org.yaml.snakeyaml.events.Event;

import java.util.Iterator;

public class FinderSet implements IFinderSet
{
    private final IStudentsNumberComparator studentsNumberComparator;

    @Inject
    public FinderSet(
            IStudentsNumberComparator studentsNumberComparator
    )
    {
        this.studentsNumberComparator = studentsNumberComparator;
    }

    @Override
    public IDepartment findMaxStudentDepartment(IInstitute institute)
    {
        IDepartment department = null;

        for (Iterator i = institute.getDepartments().iterator(); i.hasNext(); )
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
            if (studentsNumberComparator.compare(department, currentDepartment) < 0)
            {
                department = currentDepartment;
            }

        }
        return department;
    }
}
