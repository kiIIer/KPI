package Main.Tools;

import MyClasses.Abstract.IInstitute;
import MyClasses.List.Institute;

import java.io.File;
import java.io.IOException;

public interface IYamlReader
{
    IInstitute read(File file, DataType dataType) throws IOException;
}
