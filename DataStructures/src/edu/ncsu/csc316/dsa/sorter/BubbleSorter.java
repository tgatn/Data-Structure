package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * BubbleSorter uses the bubble sort algorithm to sort data
 * 
 * @author TungTran
 *
 * @param <E> the generic type of data to sort
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructor for BubbleSorter class that uses some comparator
	 * 
	 * @param comparator defines some custom ordering
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Constructor for BubbleSorter class that does not use a specific comparator
	 */
	public BubbleSorter() {
		this(null);
	}

	/**
	 * Sorts the given array using Bubble sort algorithm
	 * 
	 * @param data is array to be sorted
	 */
	public void sort(E[] data) {
		boolean r = true;
		while (r) {
			r = false;
			for (int i = 1; i < data.length; ++i) {
				if (compare(data[i], data[i - 1]) < 0) {
					E x = data[i - 1];
					data[i - 1] = data[i];
					data[i] = x;
					r = true;
				}
			}
		}
	}
}
