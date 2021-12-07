package Main.Tools;

import MyClasses.Abstract.IInstitute;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.IOException;

public class YamlWriter implements IYamlWriter
{
    @Override
    public void write(File file, IInstitute institute) throws IOException
    {
        var mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER))
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper.writeValue(file, institute);
    }
}
