package Main.Finder;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;

public interface IFinder
{
    IDepartment findMaxStudentDepartment(IInstitute institute);
}
