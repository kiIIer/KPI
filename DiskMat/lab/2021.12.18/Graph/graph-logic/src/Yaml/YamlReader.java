package Yaml;

import Tree.Branch;
import Tree.IBranch;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader implements IYamlReader
{
    @Override
    public IBranch read(File file) throws IOException
    {
        var mapper = new ObjectMapper(new YAMLFactory()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        mapper.findAndRegisterModules();

        return mapper.readValue(file, Branch.class);
    }
}
