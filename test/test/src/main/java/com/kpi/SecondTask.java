package com.kpi;

// У матриці довільного розміру поміняти місцями перший та останній рядок. Заборонено використовувати оператори циклів.
public class SecondTask {
    public double[][] lolSwap(double[][] matrix) {
        double[] temp = matrix[0];
        matrix[0] = matrix[matrix.length - 1];
        matrix[matrix.length - 1] = temp;
        return matrix;
    }
}
