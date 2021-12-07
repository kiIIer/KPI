package Main.Tools.Printers;

import Main.Tools.InvalidDataStructureException;
import MyClasses.Abstract.IDepartment;
import MyClasses.Abstract.IInstitute;
import MyClasses.Abstract.IStudent;
import com.google.inject.Inject;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

public class ExceptionPrinter implements IExceptionPrinter
{
    private final IInstitutePrinter institutePrinter;
    private final IDepartmentPrinter departmentPrinter;
    private final IStudentPrinter studentPrinter;

    @Inject
    public ExceptionPrinter(
            IInstitutePrinter institutePrinter,
            IDepartmentPrinter departmentPrinter,
            IStudentPrinter studentPrinter)
    {
        this.institutePrinter = institutePrinter;
        this.departmentPrinter = departmentPrinter;
        this.studentPrinter = studentPrinter;
    }

    @Override
    public void print(InvalidDataStructureException e, Writer writer) throws IOException
    {
        IInstitute invalidInstitute = e.getInvalidInstitute();
        if (invalidInstitute != null)
        {
            this.institutePrinter.print(invalidInstitute, writer);
        }

        Collection<IDepartment> invalidDepartments = e.getInvalidDepartments();
        if (invalidDepartments.size() != 0)
        {
            departmentPrinter.print(invalidDepartments, writer);
        }

        Collection<IStudent> invalidStudents = e.getInvalidStudents();
        if (invalidStudents.size() != 0)
        {
            studentPrinter.print(invalidStudents, writer);
        }
    }
}
