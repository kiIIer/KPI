package Main.Tools.Yaml;

import MyClasses.Abstract.IInstitute;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Writes yaml into stream.
 */
public interface IYamlWriter
{
    /**
     * Writes provided structure as yaml into provided stream.
     *
     * @param stream Stream to be written in.
     * @param object Object to be written.
     * @throws IOException In case something goes wrong. JUst the usual, we are writing.
     */
    void write(OutputStream stream, Object object) throws IOException;
}
