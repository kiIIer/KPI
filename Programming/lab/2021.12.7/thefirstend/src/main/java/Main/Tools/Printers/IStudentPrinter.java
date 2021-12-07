package Main.Tools.Printers;

import MyClasses.Abstract.IStudent;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

public interface IStudentPrinter
{
    void print(IStudent student, Writer writer) throws IOException;

    void print(Collection<IStudent> students, Writer writer) throws IOException;
}
