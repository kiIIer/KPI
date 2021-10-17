package com.kpi;

public class FirstArrayTask {
    public double getNumberOfPositives(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Cannot work with null array!");
        }
<<<<<<< HEAD
        double res = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                res++;
            }
        }
        return res;
=======
        double result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                result++;
            }
        }
        return result;
>>>>>>> DiskMat
    }
}
