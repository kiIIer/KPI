package com.kpi;

import com.google.inject.Inject;

public class SorterCommand implements ISorterCommand {

    private final IWriter writer;
    private final IGenerator generator;
    private final IMyFileReader myFileReader;

    @Inject
    public SorterCommand(IGenerator generator, IWriter writer, IMyFileReader myFileReader) {
        this.generator = generator;
        this.writer = writer;
        this.myFileReader = myFileReader;
    }

    public Integer call(ISorter sorter, AppCommand parent) throws Exception {

        double[] array;
        if (parent.filename != null) {
            array = myFileReader.read(parent.filename);
        } else {
            if (parent.min > parent.max) {
                throw new IllegalArgumentException("Min is greater than max. WTF???");
            }
            array = this.generator.genetateArray(parent.length, parent.min, parent.max);
        }

        if (parent.show) {
            this.writer.write(array);
        }

        sorter.sort(array);

        this.writer.write(array);
        return 0;
    }

}