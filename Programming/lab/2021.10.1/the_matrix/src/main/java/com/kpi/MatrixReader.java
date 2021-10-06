package com.kpi;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class MatrixReader implements IMatrixReader {
    public double[][] read(String filename) throws IOException, CsvException, NumberFormatException {
        CSVReader reader = new CSVReader(new FileReader(filename));

        List<String[]> csv = reader.readAll();

        double[][] matrix = new double[csv.size()][];

        for (int rowIndex = 0; rowIndex < csv.size(); rowIndex++) {
            String[] csvRow = csv.get(rowIndex);
            double[] row = new double[csvRow.length];

            for (int columnIndex = 0; columnIndex < csvRow.length; columnIndex++) {
                row[columnIndex] = Double.parseDouble(csvRow[columnIndex]);
            }

            matrix[rowIndex] = row;
        }
        return matrix;
    }
}
