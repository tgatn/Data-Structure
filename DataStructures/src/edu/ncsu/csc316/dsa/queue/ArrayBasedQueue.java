package edu.ncsu.csc316.dsa.queue;

import java.util.NoSuchElementException;

/**
 * The Array-based Queue is implemented as a circular array-based data structure
 * to support efficient, O(1) worst-case Queue abstract data type behaviors. The
 * internal array dynamically resizes using the doubling strategy to ensure O(1)
 * amortized cost for adding to the queue.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the queue
 */
public class ArrayBasedQueue<E> extends AbstractQueue<E> {

	/**
	 * Internal array to store the data within the queue
	 */
	private E[] data;

	/**
	 * A reference to the index of the first element in the queue
	 */
	private int front = 0;

	/**
	 * A reference to the index immediately after the last element in the queue
	 */
	private int rear;

	/**
	 * The number of elements stored in the queue
	 */
	private int size;

	/**
	 * The initial default capacity of the internal array that stores the data
	 */
	private static final int DEFAULT_CAPACITY = 0;

	/**
	 * Constructs a new array-based queue with the given initialCapcity for the
	 * array
	 * 
	 * @param initialCapacity the initial capacity to use when creating the initial
	 *                        array
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedQueue(int initialCapacity) {
		data = (E[]) (new Object[initialCapacity]);
		size = 0;
	}

	/**
	 * Constructs a new array-based queue with the default initial capacity for the
	 * array
	 */
	public ArrayBasedQueue() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * To ensure amortized O(1) cost for adding to the array-based queue, use the
	 * doubling strategy on each resize. Here, we add +1 after doubling to handle
	 * the special case where the initial capacity is 0 (otherwise, 0*2 would still
	 * produce a capacity of 0).
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
			@SuppressWarnings("unchecked")
			E[] newData = (E[]) (new Object[newCapacity]);

			if (oldCapacity == 0) {
				data = newData;
			} else {
				for (int i = 0; i < size() + 1; i++) {
					newData[i] = data[front];
					front = (front + 1) % data.length;
				}
				data = newData;
				front = 0;
				rear = size() + 1;
			}

		}
	}

	@Override
	public void enqueue(E element) {
		ensureCapacity(data.length + 1);
		rear = (front + size()) % data.length;
		data[rear] = element;
		size++;
		rear++;

	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * dequeue method on page 243 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return ret;
	}

	@Override
	public E front() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return data[front];
	}

	@Override
	public int size() {
		return size;
	}

}