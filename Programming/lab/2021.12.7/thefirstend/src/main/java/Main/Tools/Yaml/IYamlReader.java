package Main.Tools.Yaml;

import Main.Tools.CollectionType;
import MyClasses.Abstract.IInstitute;

import java.io.File;
import java.io.IOException;

/**
 * Reads from yaml file.
 */
public interface IYamlReader
{
    /**
     * Reads from provided yaml file into the abstract institute with specified collection type as a base.
     * @param file File to be read from.
     * @param collectionType Collection type to be read into and then translated into abstract institute.
     * @return Abstract institute representation.
     * @throws IOException In case something goeas wrong. Usual reading from file stuff.
     */
    IInstitute read(File file, CollectionType collectionType) throws IOException;
}
