package com.kpi;

public class App2 {
    public static void main(String[] args) {
        double[] arr1Valid = new double[] { 1, -2, -4, 3, -4, 3 };
        SecondArrayTask task = new SecondArrayTask();
        try {
            double result = task.getMinimalPositive(arr1Valid);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
