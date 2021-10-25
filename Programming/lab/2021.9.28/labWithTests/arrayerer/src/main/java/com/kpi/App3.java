package com.kpi;

public class App3 {
    public static void main(String[] args) {
        double[] arr1Valid = new double[] { 1, -2, -4, 3, -4, 3 };
        double[] arr2Valid = new double[] {1,1,-3,0,1,1};
        ThirdArrayTask task = new ThirdArrayTask();
        try {
            double[] result = task.makeArray(arr1Valid, arr2Valid);
            for(double x:result){
                System.out.print(x + " ");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
