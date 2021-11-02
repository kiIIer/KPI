package com.kpi;

import com.google.inject.Inject;

public class Swapper implements IMatrixProcessor{
    private final IMatrixWriter writer;

    @Inject
    public Swapper(IMatrixWriter writer){
        this.writer = writer;
    }

    public void process(double[][] matrix) {
        writer.write(lolSwap(matrix));
    }
    private double[][] lolSwap(double[][] matrix){
        double[] first = matrix[0];
        matrix[0] = matrix[matrix.length-1]; 
        matrix[matrix.length-1] = first;
        return matrix;
    }

}
