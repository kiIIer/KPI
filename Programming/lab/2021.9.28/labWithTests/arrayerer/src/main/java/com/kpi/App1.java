package com.kpi;

public class App1 {
    public static void main(String[] args) {
        double[] arr1Valid = new double[] { 1, -2, -4, 3, -4, 3 };
        FirstArrayTask task = new FirstArrayTask();
        try {
            double result = task.getNumberOfPositives(arr1Valid);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
