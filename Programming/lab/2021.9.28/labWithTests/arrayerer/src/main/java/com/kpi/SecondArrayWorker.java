package com.kpi;

public class SecondArrayWorker {
    public double work(double[] array) {
        if (array == null || array.length == 0) {
            return Double.NaN;
        }

        double element = Double.POSITIVE_INFINITY;
        double place = 0;
        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] < element) {
                element = array[i];
                place = i;
                found = true;
            }
        }

        if (!found) {
            return Double.NaN;
        }

        return element + place;
    }
}
