package Main.Tools;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;
import java.util.LinkedList;

public class InvalidDataStructureException extends Exception
{
    private IInstitute invalidInstitute;
    private Collection<IDepartment> invalidDepartments;
    private Collection<IStudent> invalidStudents;

    public IInstitute getInvalidInstitute()
    {
        return invalidInstitute;
    }

    public void setInvalidInstitute(IInstitute invalidInstitute)
    {
        this.invalidInstitute = invalidInstitute;
    }

    public Collection<IDepartment> getInvalidDepartments()
    {
        return invalidDepartments;
    }

    public void addInvalidDepartment(IDepartment invalidDepartment)
    {
        this.invalidDepartments.add(invalidDepartment);
    }

    public Collection<IStudent> getInvalidStudents()
    {
        return invalidStudents;
    }

    public void addInvalidStudent(IStudent invalidStudent)
    {
        this.invalidStudents.add(invalidStudent);
    }

    public InvalidDataStructureException()
    {
        this.invalidInstitute = null;
        this.invalidDepartments = new LinkedList<IDepartment>();
        this.invalidStudents = new LinkedList<IStudent>();
    }


}
