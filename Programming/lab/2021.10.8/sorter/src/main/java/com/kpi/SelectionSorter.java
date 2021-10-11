package com.kpi;

public class SelectionSorter implements ISorter {
	
	public void sort(double[] array) {
		int len = array.length;

		for (int i = 0; i < len - 1; i++) {
			int currentMinxIndex = i;

			for (int j = i + 1; j < len; j++) {
				if (array[j] < array[currentMinxIndex]) {
					currentMinxIndex = j;
				}
			}
			swap(array, i, currentMinxIndex);
		}
	}

	private void swap(double[] array, int i, int j) {
		double temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
