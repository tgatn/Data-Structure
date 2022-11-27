package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {

	/**
	 * Sorts a given array using the counting sort algorithm
	 * 
	 * @param data is an array to be sorted
	 */
	public void sort(E[] data) {

		int min = data[0].getId();
		int max = data[0].getId();
		for (int i = 0; i < data.length; ++i) {
			if (data[i].getId() < min) {
				min = data[i].getId();
			}
			if (data[i].getId() > max) {
				max = data[i].getId();
			}
		}

		int k = max - min + 1;

		int[] b = new int[k];
		for (int i = 0; i <= data.length - 1; ++i) {
			b[data[i].getId() - min] = b[data[i].getId() - min] + 1;
		}

		for (int i = 1; i <= k - 1; ++i) {
			b[i] = b[i - 1] + b[i];
		}

		@SuppressWarnings("unchecked")
		E[] f = (E[]) (new Identifiable[data.length]);

		for (int i = data.length - 1; i >= 0; --i) {
			f[b[data[i].getId() - min] - 1] = data[i];
			b[data[i].getId() - min] = b[data[i].getId() - min] - 1;
		}

		for (int i = 0; i <= f.length - 1; ++i) {
			data[i] = f[i];
		}

	}

}
