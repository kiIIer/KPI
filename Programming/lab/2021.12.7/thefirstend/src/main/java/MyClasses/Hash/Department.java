package MyClasses.Hash;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IStudent;

import java.util.HashSet;
import java.util.Set;

public class Department implements IDepartment
{
    private String name;
    private Set<IStudent> students;

    public void setStudents(Set<Student> students)
    {
        this.students = new HashSet<IStudent>(students);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Set<IStudent> getStudents()
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
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode()
    {
        return name != null ? name.hashCode() : 0;
    }
}
