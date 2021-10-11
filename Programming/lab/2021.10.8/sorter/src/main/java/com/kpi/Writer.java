package com.kpi;

public class Writer {
    public void write(double[] array) {
        for (double x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
