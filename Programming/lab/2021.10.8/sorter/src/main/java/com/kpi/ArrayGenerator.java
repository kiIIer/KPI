package com.kpi;

public class ArrayGenerator {
    public double[] genetateArray(int length) {
        double[] array = new double[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}
