package com.kpi;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

public class AlgorithmProvider implements IAlgorithmProvider {
    private final Map<String, ISorter> algorithms;

    public Map<String, ISorter> getAlgorithms() {
        return algorithms;
    }

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
}
