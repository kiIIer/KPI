package com.kpi;

public class App1 {
    public static void main(String[] args) {
        Executioner executioner = new Executioner();

        double[] arr1Valid = new double[] { 1, -2, -4, 3, -4, 3 };
        executioner.executeT1(arr1Valid);

        System.out.println();

        double[] arr1NotValid = null;
        executioner.executeT1(arr1NotValid);
    }
}
