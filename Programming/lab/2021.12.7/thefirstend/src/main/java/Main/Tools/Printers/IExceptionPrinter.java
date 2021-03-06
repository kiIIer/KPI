package Main.Tools.Printers;

import Main.Tools.MyClasses.InvalidDataStructureException;

import java.io.IOException;
import java.io.Writer;

public interface IExceptionPrinter
{
    void print(InvalidDataStructureException e, Writer writer) throws IOException;
}
