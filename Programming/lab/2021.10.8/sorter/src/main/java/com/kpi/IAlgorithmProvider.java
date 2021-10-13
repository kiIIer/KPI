package com.kpi;

import java.util.Set;

public interface IAlgorithmProvider {
    public ISorter getAlgorithm(String name);

    public Set<String> getSupportedAlgorithms();
}
