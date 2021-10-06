package com.kpi;

import java.util.ArrayList;
import java.util.List;

public class MinInMax implements IMatrixProcessor {
    public void process(double[][] matrix) {
        System.out.println(getMin(matrix));
    }

    private double getMin(double[][] matrix) {
        double[] sumsOfColumns = getModulesSums(matrix);

        List<Integer> columns = getMaxColumnIndexes(sumsOfColumns);

        return getMin(matrix, columns);
    }

    private double[] getModulesSums(double[][] matrix) {
        double[] array = new double[matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            double sum = 0;

            for (int column = 0; column < matrix[0].length; column++) {
                sum += Math.abs(matrix[column][row]);
            }

            array[row] = sum;
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
