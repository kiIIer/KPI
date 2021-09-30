package com.kpi;

public class ThirdArrayTask {
    public double[] makeArray(double[] arr1, double[] arr2) {
        if ((arr1 == null || arr2 == null) || arr1.length != arr2.length) {
            throw new IllegalArgumentException("Please enter valid imput!");
        }

        double[] result = new double[arr2.length];

        for (int i = 0; i < result.length; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                result[i] = arr1[i] + arr2[i];
                continue;
            }
            if (arr1[i] < 0 && arr2[i] < 0) {
                result[i] = arr1[i] * arr2[i];
            }
        }

        return result;
    }
}
