package com.kpi;

// Поміняти місцями стовпчики прямокутної матриці, що містять мінімальний та максимальний елементи. Якщо мінімальний або максимальний елементи зустрічаються у матриці кілька разів, при виборі мінімального слід обрати перший з таких стовпчиків, а при виборі максимального – останній.

public class ThirdTask {
    public double[][] swapColumns(double[][] matrix) {
        int minColumn = findMinColumn(matrix);
        int maxColumn = findMaxColumn(matrix);

        return swap(matrix, minColumn, maxColumn);
    }

    private int findMinColumn(double[][] matrix) {
        double min = matrix[0][0];
        int minColumn = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minColumn = j;
                }
            }
        }
        return minColumn;
    }

    private int findMaxColumn(double[][] matrix) {
        double max = matrix[0][0];
        int maxColumn = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] >= max) {
                    max = matrix[i][j];
                    maxColumn = j;
                }
            }
        }

        return maxColumn;
    }

    private double[][] swap(double[][] matrix, int minColumn, int maxColumn) {
        double[] tempColumn = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            tempColumn[i] = matrix[i][minColumn];
            matrix[i][minColumn] = matrix[i][maxColumn];
            matrix[i][maxColumn] = tempColumn[i];
        }
        return matrix;
    }
}
