package MyClasses.Abstract;

import java.util.Collection;
import java.util.Iterator;

/**
 * Abstract representation of all institutes. Unique factor: Name.
 */
public interface IInstitute
{
    /**
     * Getter.
     *
     * @return The name of institute.
     */
    public String getName();

    /**
     * Getter.
     *
     * @return All departments of this institute.
     */
    public Collection<IDepartment> getDepartments();

    /**
     * Creates Iterator on all students.
     *
     * @return Iterator on students.
     */
    public Iterator<IStudent> getStudentsIterator();

    /**
     * Adds provided department to the department collection.
     *
     * @param department department to be added.
     */
    public void addDepartment(IDepartment department);

    /**
     * Removed provided department from the department collection.
     *
     * @param department department to be removed.
     */
    public void removeDepartment(IDepartment department);
}
