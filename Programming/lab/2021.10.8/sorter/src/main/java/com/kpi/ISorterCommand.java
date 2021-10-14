package com.kpi;

public interface ISorterCommand {
    public Integer call(ISorter sorter, AppCommand parent) throws Exception;
}
