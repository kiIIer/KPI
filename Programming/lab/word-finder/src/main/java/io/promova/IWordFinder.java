package io.promova;

import java.io.File;
import java.io.IOException;

public interface IWordFinder
{
    String find(File file) throws IOException;
}
