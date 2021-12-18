package Yaml;

import Tree.IBranch;

import java.io.File;
import java.io.IOException;

public interface IYamlReader
{
    IBranch read(File file) throws IOException;
}
