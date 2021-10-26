package com.kpi;

public class Writer implements IWriter {
    public void write(double[] array) {
        for (double x : array) {
            System.out.print(String.format("%.0f ", x));
        }
        System.out.println();
    }
}
