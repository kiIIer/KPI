package Main.Tools;

import MyClasses.Abstract.IInstitute;

import java.io.File;
import java.io.IOException;

public interface IYamlWriter
{
    void write(File file, IInstitute institute) throws IOException;
}
