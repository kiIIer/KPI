package Main.Tools.MyClasses;

import Main.Tools.Errors;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Is throws when validating structure.
 */
public class InvalidDataStructureException extends Exception
{

    private Errors errors;

    /**
     * Default constuctor. Initializes this exception.
     */
    public InvalidDataStructureException()
    {
        this.errors = new Errors();
        this.errors.invalidInstitute = null;
        this.errors.invalidDepartments = new LinkedList<IDepartment>();
        this.errors.invalidStudents = new LinkedList<IStudent>();
    }

    /**
     * Getter.
     *
     * @return Returns collection of invalid students.
     */
    public IInstitute getInvalidInstitute()
    {
        return this.errors.invalidInstitute;
    }

    /**
     * Setter.
     *
     * @param invalidInstitute Institute to be set.
     */
    public void setInvalidInstitute(IInstitute invalidInstitute)
    {
        this.errors.invalidInstitute = invalidInstitute;
    }

    /**
     * Getter.
     *
     * @return Returns collection of invalid departments.
     */
    public Collection<IDepartment> getInvalidDepartments()
    {
        return this.errors.invalidDepartments;
    }

    /**
     * Adds provided department to collection of invalid departments.
     *
     * @param invalidDepartment Department to be added.
     */
    public void addInvalidDepartment(IDepartment invalidDepartment)
    {
        this.errors.invalidDepartments.add(invalidDepartment);
    }

    /**
     * Getter.
     *
     * @return Returns collection of invalid students.
     */
    public Collection<IStudent> getInvalidStudents()
    {
        return this.errors.invalidStudents;
    }

    /**
     * Adds invalid student to collection of invalid students.
     *
     * @param invalidStudent Invalid student to be added.
     */
    public void addInvalidStudent(IStudent invalidStudent)
    {
        this.errors.invalidStudents.add(invalidStudent);
    }


    /**
     * Getter.
     *
     * @return Returns Errors DTO containing all invalid elements.
     */
    public Errors getErrors()
    {
        return this.errors;
    }
}