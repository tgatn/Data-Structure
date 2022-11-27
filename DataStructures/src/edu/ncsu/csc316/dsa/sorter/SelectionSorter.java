package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructor for SelectionSorter class that uses some comparator
	 * 
	 * @param comparator defines some custom ordering
	 */
	public SelectionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Constructor for SelectionSorter class that does not use a specific comparator
	 */
	public SelectionSorter() {
		this(null);
	}

	/**
	 * Sorts the given array using Selection sort algorithm
	 * 
	 * @param data is array to be sorted
	 */
	public void sort(E[] data) {
		for (int i = 0; i < data.length; ++i) {
			int min = i;
			for (int j = i + 1; j < data.length; ++j) {
				if (compare(data[j], data[min]) < 0) {
					min = j;
				}
			}
			if (i != min) {
				E x = data[i];
				data[i] = data[min];
				data[min] = x;
			}
		}
	}
}
