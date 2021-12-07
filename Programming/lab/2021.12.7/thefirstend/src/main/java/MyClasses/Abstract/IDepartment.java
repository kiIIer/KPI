package MyClasses.Abstract;

import java.util.Collection;

public interface IDepartment
{
    public String getName();

    public Collection<IStudent> getStudents();

    public void addStudent(IStudent student);

    public void removeStudent(IStudent student);
}
