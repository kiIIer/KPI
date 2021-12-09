package Main.Tools.MyClasses;

import MyClasses.Abstract.IDepartment;

import java.util.Collection;
import java.util.Objects;

public class DepartmentFinder implements IDepartmentFinder
{
    @Override
    public IDepartment find(String name, Collection<IDepartment> departments)
    {
        for (IDepartment department :
                departments)
        {
            if (Objects.equals(name, department.getName()))
            {
                return department;
            }
        }
        return null;
    }
}
