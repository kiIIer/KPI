package com.kpi;

public class App2 {
    public static void main(String[] args) {
        Executioner executioner = new Executioner();

        double[] arr2Valid = new double[] { 1, -2, -4, 3, -4, 3 };
        executioner.executeT2(arr2Valid);

        System.out.println();

        double[] arr2NotValid = null;
        executioner.executeT2(arr2NotValid);
    }
}
