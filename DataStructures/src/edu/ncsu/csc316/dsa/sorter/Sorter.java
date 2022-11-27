package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * 
 * @author Dr. King
 * 
 * @param <E> the generic type of data to sort
 */
public interface Sorter<E> {

	/**
	 * Sorts a given array of objects
	 * 
	 * @param data is an array of some generic element to be sorted
	 */
	void sort(E[] data);
}
