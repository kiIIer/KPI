package com.kpi;

public class App3 {
    public static void main(String[] args) {
        Executioner executioner = new Executioner();

        double[] arr31Valid = new double[] { -11, 7, 4, 1, 11, 10, -2, 0, 9, 11 };
        double[] arr32Valid = new double[] { -20, 6, 15, -15, 8, -13, 19, 20, 0, 1 };
        executioner.executeT3(arr31Valid, arr32Valid);

        System.out.println();

        double[] arr31NotValid = null;
        double[] arr32NotValid = {};
        executioner.executeT3(arr31NotValid, arr32NotValid);
    }
}
