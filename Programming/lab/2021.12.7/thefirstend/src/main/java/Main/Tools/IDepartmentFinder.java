package Main.Tools;

import MyClasses.Abstract.IDepartment;

import java.util.Collection;

public interface IDepartmentFinder
{
    IDepartment find(String name, Collection<IDepartment> departments);
}
