package Main.Finder;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;

/**
 * Abstract representation of finder. Finds the largest department in provided institute.
 */
public interface IFinder
{
    /**
     * Finds department with the largest amount of students in it. Uses IStudentNumberComparator.
     * @param institute Institute to find department in.
     * @return Abstract representation of found department.
     */
    IDepartment findMaxStudentDepartment(IInstitute institute);
}
