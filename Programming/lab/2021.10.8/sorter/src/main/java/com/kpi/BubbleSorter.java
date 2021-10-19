package com.kpi;

public class BubbleSorter implements IBubbleSorter {
	public void sort(double[] array) {
		int len = array.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (array[j] <= array[j + 1]) {
					continue;
				}

				swap(array, j, j + 1);
			}
		}
	}

	private void swap(double[] array, int i, int j) {
		double temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
