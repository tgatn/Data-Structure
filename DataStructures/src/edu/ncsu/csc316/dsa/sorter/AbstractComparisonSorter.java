package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Abstract class that holds common functionality such as compare(E, E),
 * NaturalOrder inner class, and setComparator(Comparator) for InsertionSorter
 * and SelectionSorter classes
 * 
 * @author TungTran
 *
 * @param <E> the generic type of data to sort
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	/** instance of comparator */
	private Comparator<E> comparator;

	/**
	 * Constructor for AbstractComparisonSorter with parameter for comparator
	 * 
	 * @param comparator defines some custom ordering
	 */
	public AbstractComparisonSorter(Comparator<E> comparator) {
		setComparator(comparator);
	}

	private void setComparator(Comparator<E> comparator) {
		if (comparator == null) {
			this.comparator = new NaturalOrder();
		} else {
			this.comparator = comparator;
		}
	}

	private class NaturalOrder implements Comparator<E> {
		public int compare(E first, E second) {
			return ((Comparable<E>) first).compareTo(second);
		}
	}

	/**
	 * Compares two parameters and returns 0 if both are equal, -1 if data1 belongs
	 * before data2; 1 if data1 belongs after data2
	 * 
	 * @param data1 first data to be compared
	 * @param data2 second data to be compared
	 * @return 0 if both are equal, -1 if data1 belongs before data2; 1 if data1
	 *         belongs after data2
	 */
	public int compare(E data1, E data2) {
		return comparator.compare(data1, data2);
	}
}
