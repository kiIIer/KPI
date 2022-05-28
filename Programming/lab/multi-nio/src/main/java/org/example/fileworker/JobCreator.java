package org.example.fileworker;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class JobCreator implements IJobCreator
{
    @Override
    public List<Job> create(List<File> files, Statistic statistics)
    {
        return files.stream().map(file -> new Job(file, statistics)).toList();
    }
}
