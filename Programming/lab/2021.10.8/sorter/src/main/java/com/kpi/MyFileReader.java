package com.kpi;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class MyFileReader implements IMyFileReader {

    public double[] read(String filename) throws IOException, CsvException, NumberFormatException {
        CSVReader reader = new CSVReader(new FileReader(filename));

        String[] csv = reader.readNext();

        double[] array = new double[csv.length];

        for (int i = 0; i < csv.length; i++) {
            array[i] = Double.parseDouble(csv[i]);
        }

        return array;
    }

}
