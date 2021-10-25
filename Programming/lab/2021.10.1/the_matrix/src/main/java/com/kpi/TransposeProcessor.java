package com.kpi;

import com.google.inject.Inject;

public class TransposeProcessor implements IMatrixProcessor {
    private IMatrixWriter writer;

    @Inject
    public TransposeProcessor(IMatrixWriter writer) {
        this.writer = writer;
    }

    public void process(double[][] matrix) {
        writer.write(transpose(matrix));
    }

    private double[][] transpose(double[][] matrix) {
        int columnCount = matrix[0].length;
        double[][] transMatrix = new double[columnCount][matrix.length];

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                transMatrix[columnIndex][rowIndex] = matrix[rowIndex][columnIndex];
            }
        }

        return transMatrix;
    }

}
