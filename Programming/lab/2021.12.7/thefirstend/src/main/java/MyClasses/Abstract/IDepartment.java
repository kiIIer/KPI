package MyClasses.Abstract;

import java.util.Collection;

/**
 * Abstract representation of all departments. Unique factor: Name.
 */
public interface IDepartment
{
    /**
     * Getter.
     *
     * @return The name of this department.
     */
    public String getName();

    /**
     * Getter.
     *
     * @return All the students in this department.
     */
    public Collection<IStudent> getStudents();

    /**
     * Adds provided student to student collection.
     *
     * @param student student to be added.
     */
    public void addStudent(IStudent student);

    /**
     * Removed provided student form student collection.
     *
     * @param student student to be removed.
     */
    public void removeStudent(IStudent student);
}
