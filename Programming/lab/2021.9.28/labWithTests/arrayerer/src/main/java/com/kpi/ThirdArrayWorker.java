package com.kpi;

public class ThirdArrayWorker {
    public double[] work(double[] arr1, double[] arr2) {
        if ((arr1 == null || arr2 == null) || arr1.length != arr2.length) {
            return null;
        }
        double[] res = new double[arr2.length];
        for (int i = 0; i < res.length; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                res[i] = arr1[i] + arr2[i];
            } else if (arr1[i] < 0 && arr2[i] < 0) {
                res[i] = arr1[i] * arr2[i];
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
