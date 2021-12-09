package Main.Tools;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;

/**
 * Class which contains errors found while validating. DTO.
 */
public class Errors
{
    public IInstitute invalidInstitute;
    public Collection<IDepartment> invalidDepartments;
    public Collection<IStudent> invalidStudents;
}
