package Main.Tools.MyClasses;

import MyClasses.Abstract.IDepartment;

import java.util.Collection;

/**
 * Used to find departments.
 */
public interface IDepartmentFinder
{
    /**
     * Searches department with provided name in provided colleciton.
     *
     * @param name        Name of department to be look for.
     * @param departments Collection to be looked in.
     * @return Found department.
     */
    IDepartment find(String name, Collection<IDepartment> departments);
}
