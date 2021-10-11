package com.kpi;

public class InsertionSorter implements ISorter {

    public void sort(double[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            double current = array[i];

            int j;
            for (j = i - 1; (j > -1) && array[j] > current; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = current;
        }
    }

}
