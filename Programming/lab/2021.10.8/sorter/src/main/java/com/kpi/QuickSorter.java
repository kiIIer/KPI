package com.kpi;

public class QuickSorter implements IQuickSorter {
    public void sort(double[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(double[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int dividerIndex = divideAndConquer(array, start, end);

        quickSort(array, start, dividerIndex - 1);
        quickSort(array, dividerIndex + 1, end);
    }

    private int divideAndConquer(double[] array, int start, int end) {
        int greaterArrayStart = start;

        double conqueror = array[end];

        for (int index = start; index < end; index++) {
            if (array[index] >= conqueror) {
                continue;
            }
            greaterArrayStart++;

            swap(array, greaterArrayStart - 1, index);

        }

        swap(array, greaterArrayStart, end);

        return greaterArrayStart;
    }

    private void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
