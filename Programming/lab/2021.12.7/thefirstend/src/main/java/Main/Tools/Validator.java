package Main.Tools;

import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;

import java.util.Collection;
import java.util.LinkedList;

public class Validator implements IValidator
{

    @Override
    public void validate(IInstitute institute) throws InvalidDataStructureException
    {
        InvalidDataStructureException e = new InvalidDataStructureException();
        if (institute.getDepartments() == null)
        {
            e.setInvalidInstitute(institute);
            throw e;
        }

        if (institute.getName() == null)
        {
            e.setInvalidInstitute(institute);
        }

        for (IDepartment department :
                institute.getDepartments())
        {
            if (department.getName() == null)
            {
                e.addInvalidDepartment(department);
            }
            if (department.getStudents() == null)
            {
                e.addInvalidDepartment(department);
                institute.removeDepartment(department);
            }
        }

        var i = institute.getStudentsIterator();
        while (i.hasNext())
        {
            IStudent student = i.next();

            if (student.getGradeBookId() == null || student.getName() == null || student.getSurname() == null || student.getGrade() < 0 || student.getGrade() > 100)
            {
                e.addInvalidStudent(student);
            }
        }

        throwIfHasInvalid(e);

        Collection<IStudent> set = new LinkedList<>();

        i = institute.getStudentsIterator();
        while (i.hasNext())
        {
            IStudent student = i.next();

            if (set.contains(student))
            {
                e.addInvalidStudent(student);
                continue;
            }
            set.add(student);

        }

        throwIfHasInvalid(e);

    }

    private void throwIfHasInvalid(InvalidDataStructureException e) throws InvalidDataStructureException
    {
        if (e.getInvalidInstitute() != null || e.getInvalidDepartments().size() != 0 || e.getInvalidStudents().size() != 0)
        {
            throw e;
        }
    }
}
