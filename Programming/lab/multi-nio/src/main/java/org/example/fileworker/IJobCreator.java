package org.example.fileworker;

import java.io.File;
import java.util.List;

public interface IJobCreator
{
    List<Job> create(List<File> files, Statistic statistics);
}
