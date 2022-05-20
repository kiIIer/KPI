package org.example.fileworker;

import java.io.File;
import java.util.List;

public record Job(File file, Statistic statistics)
{
}
