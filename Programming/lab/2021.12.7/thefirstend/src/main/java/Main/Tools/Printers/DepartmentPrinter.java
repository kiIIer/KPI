package Main.Tools.Printers;

import MyClasses.Abstract.IDepartment;
import com.google.inject.Inject;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

public class DepartmentPrinter implements IDepartmentPrinter
{
    private final IStudentPrinter studentPrinter;

    @Inject
    public DepartmentPrinter(IStudentPrinter studentPrinter)
    {
        this.studentPrinter = studentPrinter;
    }

    @Override
    public void print(IDepartment department, Writer writer) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Department{" + "name:'").append(department.getName()).append("', Students:'").append("\n");

        writer.write(builder.toString());

        studentPrinter.print(department.getStudents(), writer);

        builder.delete(0, builder.length() - 1);

        builder.append("'}");

        writer.write(builder.toString());
    }

    @Override
    public void print(Collection<IDepartment> departments, Writer writer) throws IOException
    {
        for (IDepartment department :
                departments)
        {
            print(department, writer);
            writer.write("\n");
        }
    }
}
