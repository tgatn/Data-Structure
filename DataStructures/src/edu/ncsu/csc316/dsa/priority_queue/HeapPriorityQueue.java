package edu.ncsu.csc316.dsa.priority_queue;

import java.util.Comparator;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * A HeapPriorityQueue is an array-based min-heap implementation of the
 * PriorityQueue abstract data type. HeapPriorityQueue ensures a O(logn)
 * worst-case runtime for insert and deleteMin. HeapPriorityQueue ensures a O(1)
 * worst-case runtime for min, size, and isEmpty.
 * 
 * The HeapPriorityQueue class is based on an implementation developed for use
 * with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <K> the type of keys (priorities) stored in the priority queue
 * @param <V> the type of values that are associated with keys in the priority
 *            queue
 */
public class HeapPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {

	/**
	 * The internal array-based list used to model the heap
	 */
	protected ArrayBasedList<Entry<K, V>> list;

	/**
	 * Constructs a new HeapPriorityQueue using a custom comparator
	 * 
	 * @param comparator the custom Comparator to use when comparing keys
	 *                   (priorities)
	 */
	public HeapPriorityQueue(Comparator<K> comparator) {
		super(comparator);
		list = new ArrayBasedList<Entry<K, V>>();
	}

	/**
	 * Constructs a new HeapPriorityQueue that compares keys (priorities) using the
	 * natural ordering of the key type
	 */
	public HeapPriorityQueue() {
		this(null);
	}

	//////////////////////////////////////////////////
	// Convenience methods to help abstract the math
	// involved in determining parent or children in
	// an array-based implementation of a min-heap
	//////////////////////////////////////////////////

	/**
	 * Returns the index of the parent of the entry at the given index
	 * 
	 * @param index the index of the entry for which to return a reference to its
	 *              parent
	 * @return the index of the parent of the entry at the given index
	 */
	protected int parent(int index) {
		return (index - 1) / 2;
	}

	/**
	 * Returns the index of the left child of the entry at the given index
	 * 
	 * @param index the index of the entry for which to return a reference to its
	 *              left child
	 * @return the index of the left child of the entry at the given index
	 */
	protected int left(int index) {
		return 2 * index + 1;
	}

	/**
	 * Returns the index of the right child of the entry at the given index
	 * 
	 * @param index the index of the entry for which to return a reference to its
	 *              right child
	 * @return the index of the right child of the entry at the given index
	 */
	protected int right(int index) {
		return 2 * index + 2;
	}

	/**
	 * Returns true if the entry at the given index has a left child
	 * 
	 * @param index the index of the entry for which to check for a left child
	 * @return true if the entry at the given index has a left child; otherwise,
	 *         return false
	 */
	protected boolean hasLeft(int index) {
		return left(index) < list.size();
	}

	/**
	 * Returns true if the entry at the given index has a right child
	 * 
	 * @param index the index of the entry for which to check for a right child
	 * @return true if the entry at the given index has a right child; otherwise,
	 *         return false
	 */
	protected boolean hasRight(int index) {
		return right(index) < list.size();
	}

	//////////////////////////////////////////
	// ADT Operations
	//////////////////////////////////////////

	@Override
	public Entry<K, V> insert(K key, V value) {
		/*
		 * Citing Help from the Textbooks The code for this method is based on the
		 * insert algorithm on page 378 in the course textbook "Data Structures and
		 * Algorithms" by Goodrich, Tamassia, Goldwasser.
		 */
		Entry<K, V> temp = createEntry(key, value);
		list.addLast(temp);
		upHeap(list.size() - 1);
		return temp;
		
	}

	@Override
	public Entry<K, V> min() {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Entry<K, V> deleteMin() {
		if (list.isEmpty()) {
			return null;
		}
		/*
		 * Citing Help from the Textbooks The code for this method is based on the
		 * removeMin algorithm on page 378 in the course textbook "Data Structures and
		 * Algorithms" by Goodrich, Tamassia, Goldwasser.
		 */
		Entry<K, V> temp = list.get(0);
		swap(0, list.size() - 1);
		list.remove(list.size() - 1);
		downHeap(0);
		return temp;
	}

	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Ensures the min-heap ordering property is maintained appropriately by
	 * comparing an entry's key (priority) with the key of its parent, swapping the
	 * entries if necessary
	 * 
	 * @param index the index of the entry at which to determine if up-heap is
	 *              necessary to preserve the min-heap ordering property
	 */
	protected void upHeap(int index) {
		/*
		 * Citing Help from the Textbooks The code for this method is based on the
		 * upheap algorithm on page 377 in the course textbook "Data Structures and
		 * Algorithms" by Goodrich, Tamassia, Goldwasser.
		 */
		int j = index;
		while (j > 0) {
			int p = parent(j);
			if (compare(list.get(j).getKey(), list.get(p).getKey()) >= 0) {
				break;
			}
			swap(j, p);
			j = p;
		}
	}

	/**
	 * Swaps the entry at index1 with the entry at index2
	 * 
	 * @param index1 the index of the first entry involved in the swap
	 * @param index2 the index of the second entry involved in the swap
	 */
	protected void swap(int index1, int index2) {
		Entry<K, V> temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}

	/**
	 * Ensures the min-heap ordering property is maintained appropriately by
	 * comparing an entry's key (priority) with the keys of its children, swapping
	 * the entry with its lowest-priority child if necessary
	 * 
	 * @param index the index of the entry at which to determine if down-heap is
	 *              necessary to preserve the min-heap ordering property
	 */
	protected void downHeap(int index) {
		/*
		 * Citing Help from the Textbooks The code for this method is based on the
		 * downheap algorithm on page 378 in the course textbook "Data Structures and
		 * Algorithms" by Goodrich, Tamassia, Goldwasser.
		 */
		int j = index;
		while (hasLeft(j)) {
			int leftIndex = left(j);
			int smallChildIndex = leftIndex;
			if (hasRight(j)) {
				int rightIndex = right(j);
				if (compare(list.get(leftIndex).getKey(), list.get(rightIndex).getKey()) > 0) {
					smallChildIndex = rightIndex;
				}
			}
			if (compare(list.get(smallChildIndex).getKey(), list.get(j).getKey()) >= 0) {
				break;
			}
			swap(j, smallChildIndex);
			j = smallChildIndex;
		}
	}
}