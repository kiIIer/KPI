package Main.Tools.Printers;

import MyClasses.Abstract.IInstitute;
import com.google.inject.Inject;

import java.io.IOException;
import java.io.Writer;

public class InstitutePrinter implements IInstitutePrinter
{
    private final IDepartmentPrinter departmentPrinter;

    @Inject
    public InstitutePrinter(IDepartmentPrinter departmentPrinter)
    {
        this.departmentPrinter = departmentPrinter;
    }

    @Override
    public void print(IInstitute institute, Writer writer) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Institute{name:'").append(institute.getName()).append("', departments:'\n");

        writer.write(builder.toString());

        departmentPrinter.print(institute.getDepartments(), writer);

        builder.delete(0, builder.length() - 1);

        builder.append("'}");

        writer.write(builder.toString());
    }
}
