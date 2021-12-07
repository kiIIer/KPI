package Main.Tools;

import MyClasses.Abstract.IInstitute;
import MyClasses.List.Institute;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader implements IYamlReader
{
    @Override
    public IInstitute read(File file, DataType dataType) throws IOException
    {
        var mapper = new ObjectMapper(new YAMLFactory()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        mapper.findAndRegisterModules();

        switch (dataType)
        {
            case LIST -> {
                return mapper.readValue(file, Institute.class);
            }

            case TREESET -> {
                return mapper.readValue(file, MyClasses.Set.Institute.class);
            }

            case HASHSET -> {
                return mapper.readValue(file, MyClasses.Hash.Institute.class);
            }

            default -> {
                return null;
            }
        }
    }
}
