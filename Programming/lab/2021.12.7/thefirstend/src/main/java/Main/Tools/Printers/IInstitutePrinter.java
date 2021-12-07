package Main.Tools.Printers;

import MyClasses.Abstract.IInstitute;

import java.io.IOException;
import java.io.Writer;

public interface IInstitutePrinter
{
    void print(IInstitute institute, Writer writer) throws IOException;
}
