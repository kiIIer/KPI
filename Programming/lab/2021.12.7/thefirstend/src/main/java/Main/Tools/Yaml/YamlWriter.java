package Main.Tools.Yaml;

import MyClasses.Abstract.IInstitute;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class YamlWriter implements IYamlWriter
{
    @Override
    public void write(OutputStream stream, Object object) throws IOException
    {
        var mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER))
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper.writeValue(stream, object);
    }
}
