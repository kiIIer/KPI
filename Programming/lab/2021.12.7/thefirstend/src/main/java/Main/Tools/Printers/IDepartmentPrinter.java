package Main.Tools.Printers;

import MyClasses.Abstract.IDepartment;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

public interface IDepartmentPrinter
{
    void print(IDepartment department, Writer writer) throws IOException;

    void print(Collection<IDepartment> departments, Writer writer) throws IOException;
}
