package Main.Tools;

import MyClasses.Abstract.IDepartment;
import MyClasses.List.Department;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class DepartmentCreator implements IDepartmentCreator
{
    @Override
    public IDepartment create(String name, DataType dataType)
    {
        switch (dataType)
        {
            case LIST -> {
                Department department = new Department();
                department.setName(name);
                department.setStudents(new LinkedList<>());
                return department;
            }
            case TREESET -> {
                MyClasses.Set.Department department = new MyClasses.Set.Department();
                department.setName(name);
                department.setStudents(new TreeSet<>());
                return department;
            }
            case HASHSET -> {
                MyClasses.Hash.Department department = new MyClasses.Hash.Department();
                department.setName(name);
                department.setStudents(new HashSet<>());
                return department;
            }
            default -> {
                return null;
            }
        }
    }
}
