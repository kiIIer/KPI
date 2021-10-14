package com.kpi;

import com.google.inject.Inject;

import org.apache.commons.lang3.time.StopWatch;

public class SorterCommand implements ISorterCommand {

    private final IWriter writer;
    private final IGenerator generator;
    private final IMyFileReader myFileReader;
    private final IDescender descender;

    @Inject
    public SorterCommand(IGenerator generator, IWriter writer, IMyFileReader myFileReader, IDescender descender) {
        this.generator = generator;
        this.writer = writer;
        this.myFileReader = myFileReader;
        this.descender = descender;
    }

    public Integer call(ISorter sorter, AppCommand parent) throws Exception {

        double[] array;
        if (parent.array != null) {
            array = parent.array;
        } else if (parent.isRandom) {
            if (parent.min > parent.max) {
                throw new IllegalArgumentException("Min is greater than max. WTF???");
            }
            array = this.generator.genetateArray(parent.length, parent.min, parent.max);
        } else {
            array = myFileReader.read(parent.filename);
        }

        if (parent.show) {
            writer.write(array);
        }

        StopWatch watch = new StopWatch();

        watch.start();

        sorter.sort(array);

        watch.stop();

        if (parent.descending) {
            descender.descend(array);
        }

        this.writer.write(array);
        if (parent.isTime) {
            System.out.println("Time of execution: " + watch.getTime());
        }
        return 0;
    }

}