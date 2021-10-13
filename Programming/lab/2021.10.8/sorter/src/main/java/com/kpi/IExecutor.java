package com.kpi;

public interface IExecutor {
    public void setAlgorithm(String value);

    public Integer call() throws Exception;
}
