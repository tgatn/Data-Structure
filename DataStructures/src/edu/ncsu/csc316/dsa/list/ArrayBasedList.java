package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array-based list is a contiguous-memory representation of the List
 * abstract data type. This array-based list dynamically resizes to ensure O(1)
 * amortized cost for adding to the end of the list. Size is maintained as a
 * global field to allow for O(1) size() and isEmpty() behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	/**
	 * The initial capacity of the list if the client does not provide a capacity
	 * when constructing an instance of the array-based list
	 **/
	private final static int DEFAULT_CAPACITY = 0;

	/** The array in which elements will be stored **/
	private E[] data;

	/** The number of elements stored in the array-based list data structure **/
	private int size;

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * default initial capacity of the internal array
	 */
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructs a new instance of an array-based list data structure with the
	 * provided initial capacity
	 * 
	 * @param capacity the initial capacity of the internal array used to store the
	 *                 list elements
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	@Override
	public void add(int index, E element) {
		ensureCapacity(size + 1);

		checkIndexForAdd(index);
		for (int i = data.length - 1; i > index; --i) {
			data[i] = data[i - 1];
		}
		data[index] = element;
		size++;

	}

	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public E remove(int index) {

		checkIndex(index);
		E ret = data[index];
		for (int i = index; i < data.length - 1; ++i) {
			data[i] = data[i + 1];
		}
		size--;
		return ret;
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);
		E ret = data[index];
		data[index] = element;
		return ret;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/**
	 * Inner class of ArrayBasedList that serves as an iterator with the methods
	 * hasNext, next, and remove
	 * 
	 * Citation: The implementation of this private class is referencing code from the
	 * textbook "Data Structures and Algorithms in Java" section 7.4 Iterators
	 * 
	 * @author TungTran
	 *
	 */
	private class ElementIterator implements Iterator<E> {

		/** position of next element */
		private int position;

		/** indicates if remove can be called */
		private boolean removeOK;

		/**
		 * Construct a new element iterator where the cursor is initialized to the
		 * beginning of the list.
		 */
		public ElementIterator() {
			position = 0;
		}

		@Override
		public boolean hasNext() {
			return position < size;
		}

		@Override
		public E next() {
			if (position == size) {
				throw new NoSuchElementException();
			}
			removeOK = true;
			return data[position++];
		}

		@Override
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			int removePos = position - 1;
			ArrayBasedList.this.remove(removePos);
			position--;
			removeOK = false;

		}
	}

	/**
	 * To ensure amortized O(1) cost for adding to the end of the array-based list,
	 * use the doubling strategy on each resize. Here, we add +1 after doubling to
	 * handle the special case where the initial capacity is 0 (otherwise, 0*2 would
	 * still produce a capacity of 0).
	 * 
	 * @param minCapacity the minimium capacity that must be supported by the
	 *                    internal array
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = oldCapacity * 2 + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}
}