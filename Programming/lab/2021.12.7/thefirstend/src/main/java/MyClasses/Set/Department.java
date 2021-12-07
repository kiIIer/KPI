package MyClasses.Set;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IStudent;

import java.util.Set;
import java.util.TreeSet;

public class Department implements IDepartment, Comparable<IDepartment>
{
    private String name;
    private Set<IStudent> students;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStudents(Set<Student> students)
    {
        this.students = new TreeSet<IStudent>(students);
    }

    @Override
    public Set<IStudent> getStudents()
    {
        return students;
    }

    @Override
    public String getName()
    {
        return name;
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
    public int compareTo(IDepartment that)
    {
        return name.compareTo(that.getName());
    }
}
