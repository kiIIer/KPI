package MyClasses.List;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Institute implements IInstitute
{
    private String name;
    private List<IDepartment> departments;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDepartments(List<Department> departments)
    {
        this.departments = new ArrayList<IDepartment>(departments);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<IDepartment> getDepartments()
    {
        return departments;
    }

    @Override
    public Iterator<IStudent> getStudentsIterator()
    {
        Stream<IStudent> stream = Stream.of();
        for (IDepartment department :
                departments)
        {
            stream = Stream.concat(stream, department.getStudents().stream());
        }
        return stream.iterator();
    }

    @Override
    public void addDepartment(IDepartment department)
    {
        this.departments.add(department);
    }

    @Override
    public void removeDepartment(IDepartment department)
    {
        this.departments.remove(department);
    }

}
