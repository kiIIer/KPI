package com.kpi;

import com.google.inject.Inject;

public class Transposer implements IMatrixProcessor {
    private IMatrixWriter writer;

    @Inject
    public Transposer(IMatrixWriter writer) {
        this.writer = writer;
    }

    public void process(double[][] matrix) {
        writer.write(transpose(matrix));
    }

    private double[][] transpose(double[][] matrix) {
        double[][] transMatrix = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transMatrix[j][i] = matrix[i][j];
            }
        }

        return transMatrix;
    }

}
