package com.kpi;

import com.google.inject.Inject;

public class SorterCommand implements ISorterCommand {

    private final IWriter writer;
    private final IGenerator generator;

    @Inject
    public SorterCommand(IGenerator generator, IWriter writer) {
        this.generator = generator;
        this.writer = writer;
    }

    public Integer call(ISorter sorter, int length) throws Exception {
        double[] array = this.generator.genetateArray(length);

        this.writer.write(array);

        sorter.sort(array);

        this.writer.write(array);
        return 0;
    }

}