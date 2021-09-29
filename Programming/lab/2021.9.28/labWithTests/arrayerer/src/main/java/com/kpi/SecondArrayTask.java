package com.kpi;

public class SecondArrayTask {
    public double getMinimalPositive(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Cannot work with null array!");
        }

        double element = Double.POSITIVE_INFINITY;
        double place = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] < element) {
                element = array[i];
                place = i;
            }
        }

        if (place == -1) {
            return Double.NaN;
        }

        return element + place;
    }
}
