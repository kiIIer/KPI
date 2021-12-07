package MyClasses.Abstract;

import java.util.Collection;
import java.util.Iterator;

public interface IInstitute
{
    public String getName();

    public Collection<IDepartment> getDepartments();

    public Iterator<IStudent> getStudentsIterator();

    public void addDepartment(IDepartment department);

    public void removeDepartment(IDepartment department);
}
