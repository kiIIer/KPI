package com.kpi;

import com.google.inject.Inject;

public class SwapProcessor implements IMatrixProcessor {
    private final IMatrixWriter writer;

    @Inject
    public SwapProcessor(IMatrixWriter writer) {
        this.writer = writer;
    }

    public void process(double[][] matrix) {
        lolSwap(matrix);

        writer.write(matrix);
    }

    private void lolSwap(double[][] matrix) {
        double[] first = matrix[0];

        matrix[0] = matrix[matrix.length - 1];

        matrix[matrix.length - 1] = first;
    }
}
