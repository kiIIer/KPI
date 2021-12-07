package MyClasses.List;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IStudent;

import java.util.ArrayList;
import java.util.List;

public class Department implements IDepartment
{
    private String name;

    private List<IStudent> students;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStudents(List<Student> students)
    {
        this.students = new ArrayList<IStudent>(students);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<IStudent> getStudents()
    {
        return students;
    }

    @Override
    public void addStudent(IStudent student)
    {
        this.students.add(student);
    }


    @Override
    public void removeStudent(IStudent student)
    {
        this.students.remove(student);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;

        return name != null ? name.equals(that.name) : that.name == null;
    }
}
