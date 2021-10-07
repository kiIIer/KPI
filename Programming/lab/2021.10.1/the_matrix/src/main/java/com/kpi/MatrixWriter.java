package com.kpi;

public class MatrixWriter implements IMatrixWriter {
    public void write(double[][] matrix) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                System.out.print(matrix[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }

}
