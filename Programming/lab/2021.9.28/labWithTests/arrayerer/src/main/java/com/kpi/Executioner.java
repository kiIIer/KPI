package com.kpi;

public class Executioner {
    public void executeT1(double[] array){
        FirstArrayTask task = new FirstArrayTask();
        double result;
        try {
            result = task.getNumberOfPositives(array);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(result);
    }

    public void executeT2(double[] array){
        SecondArrayTask task = new SecondArrayTask();
        double result;
        try {
            result = task.getMinimalPositive(array);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(result);
    }

    public void executeT3(double[] arr1, double[] arr2){
        ThirdArrayTask task = new ThirdArrayTask();
        double[] result;
        try {
            result = task.makeArray(arr1, arr2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        for (double element : result) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
