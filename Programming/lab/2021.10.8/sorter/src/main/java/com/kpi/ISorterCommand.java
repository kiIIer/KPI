package com.kpi;

public interface ISorterCommand {
    public Integer call(ISorter sorter, int length) throws Exception;
}
