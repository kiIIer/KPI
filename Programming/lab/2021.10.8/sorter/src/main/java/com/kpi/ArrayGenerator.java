package com.kpi;

public class ArrayGenerator implements IGenerator {
    public double[] genetateArray(int length, int min, int max) {
        double[] array = new double[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) ((Math.random() * (max - min)) + min);
        }
        return array;
    }
}
