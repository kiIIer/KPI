package com.kpi;

public class SecondArrayTask {
    public double getMinimalPositive(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Cannot work with null array!");
        }

        int notFound = -1;
        int index = notFound;

        for (int i = 0; i < array.length; i++) {
            double value = array[i];
            if (value <= 0) {
                continue;
            }
            index = (index == notFound) ? i : ((value < array[index]) ? i : index);
        }

        if (index == notFound) {
            return Double.NaN;
        }

        return array[index] + index;
    }
}
