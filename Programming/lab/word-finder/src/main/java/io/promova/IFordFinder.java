package io.promova;

import java.io.File;
import java.io.IOException;

public interface IFordFinder
{
    String find(File file) throws IOException;
}
