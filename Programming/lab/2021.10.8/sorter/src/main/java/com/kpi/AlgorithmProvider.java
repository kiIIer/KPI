package com.kpi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.inject.Inject;

public class AlgorithmProvider implements IAlgorithmProvider {
    private final Map<String, ISorter> algorithms;

    @Inject
    public AlgorithmProvider(IBubbleSorter bubble, IInsertionSorter insertion, IQuickSorter quick,
            ISelectionSorter selection) {
        Map<String, ISorter> map = new HashMap<>();
        map.put("bubble", bubble);
        map.put("quick", quick);
        map.put("insertion", insertion);
        map.put("selection", selection);

        this.algorithms = map;
    }

    public ISorter getAlgorithm(String name) {
        return algorithms.get(name);
    }

    public Set<String> getSupportedAlgorithms() {
        return algorithms.keySet();
    }
}
