package com.kpi;

import java.io.IOException;
import com.opencsv.exceptions.CsvException;

public interface IMyFileReader {
    double[] read(String filename) throws IOException, CsvException, NumberFormatException;
}
