package com.kpi;

import java.util.ArrayList;
import java.util.List;

public class MinInMax implements IMatrixProcessor {
    public void  process(double[][] matrix) {
        System.out.println(getMin(matrix));
    }

    private double getMin(double[][] rawMatrix) {
        int longestRowLength = longestRowLength(rawMatrix);

        double[][] matrix = makeRectMatrix(longestRowLength, rawMatrix);

        double[] sumsOfColumns = getModulesSums(matrix);

        List<Integer> columns = getMaxColumnIndexes(sumsOfColumns);

        return getMin(matrix, columns);
    }

    private int longestRowLength(double[][] matrix){
        int maxLength = -1;
        for (int i = 0; i<matrix.length; i++){
            
            int length = matrix[i].length;
            maxLength = (length > maxLength) ? length : maxLength;
        }
        return maxLength;
    }

    private double[][] makeRectMatrix(int longestRowLength, double[][] rawMatrix){
        double[][] matrix = new double[rawMatrix.length][longestRowLength];

        for(int i = 0; i < rawMatrix.length; i++){

            for(int j = 0; j<rawMatrix[i].length; j++){
                matrix[i][j] = rawMatrix[i][j];
            }

        }

        return matrix;
    }

    private double[] getModulesSums(double[][] matrix) {
        double[] array = new double[matrix[0].length];

        for (int column = 0; column < matrix[0].length; column++) {
            double sum = 0;

            for (int row = 0; row < matrix.length; row++) {
                sum += Math.abs(matrix[row][column]);
            }

            array[column] = sum;
        }

        return array;
    }

    private List<Integer> getMaxColumnIndexes(double[] sums) {
        double maxSum = sums[0];

        for (double sum : sums) {
            if (maxSum < sum) {
                maxSum = sum;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < sums.length; i++) {
            if (sums[i] == maxSum) {
                list.add(i);
            }
        }

        return list;
    }

    private double getMin(double[][] matrix, List<Integer> columnIndexes) {
        double min = matrix[0][columnIndexes.get(0)];

        for (int columnIndex : columnIndexes) {
            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                double current = matrix[rowIndex][columnIndex];

                if (current < min) {
                    min = current;
                }
            }
        }

        return min;
    }

}
