package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * 
 * @author Dr. King
 * @author Tung Tran
 * 
 * @param <E> the generic type of data to sort
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructor for InsertionSorter class that uses some comparator
	 * 
	 * @param comparator defines some custom ordering
	 */
	public InsertionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Constructor for InsertionSorter class that does not use a specific comparator
	 */
	public InsertionSorter() {
		this(null);
	}

	/**
	 * Sorts the given array using Insertion sort algorithm
	 * 
	 * @param data is array to be sorted
	 */
	public void sort(E[] data) {
		for (int i = 1; i < data.length; ++i) {
			E x = data[i];
			int j = i - 1;
			while (j >= 0 && compare(data[j], x) > 0) {
				data[j + 1] = data[j];
				j = j - 1;
			}
			data[j + 1] = x;
		}
	}

}
