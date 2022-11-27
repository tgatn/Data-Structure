package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

	/** A reference to the dummy/sentinel node at the front of the list **/
	private LinkedListNode<E> front;

	/** A reference to the last/final node in the list **/
	private LinkedListNode<E> tail;

	/** The number of elements stored in the list **/
	private int size;

	/**
	 * Constructs an empty singly-linked list
	 */
	public SinglyLinkedList() {
		front = new LinkedListNode<E>(null);
		tail = null;
		size = 0;
	}

	/**
	 * Citation: Dr Heckman's CSC216 Lecture 16: LinkedList was used to aid in
	 * implementing this method
	 */
	@Override
	public void add(int index, E element) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {// Special case: front
			front.next = new LinkedListNode<E>(element, front.next);
			if (size == 0) {
				tail = front.next;
			}
		} else if (index == size) {
			tail.next = new LinkedListNode<E>(element);
			tail = tail.next;
		} else {
			// Use current reference
			LinkedListNode<E> current = front.next;
			// Stop BEFORE index to add at
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			// Add the node so that it points to the next
			current.next = new LinkedListNode<E>(element, current.next);

			if (current.next.next == null) {
				tail = current.next;
			}
		}
		size++;

	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/**
	 * Citation: Dr Heckman's CSC216 Lecture 16: LinkedList was used to aid in
	 * implementing this method
	 */
	@Override
	public E remove(int index) {
		checkIndex(index);

		E value = null;
		if (index == 0) { // Special Case: front of list
			value = front.next.data;
			front.next = front.next.next;
		} else {
			// removing from elsewhere in the list
			LinkedListNode<E> current = front.next;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			value = current.next.data;
			current.next = current.next.next;
		}
		size--;
		return value;
	}

	/**
	 * {@inheritDoc} For a singly-linked list, this behavior has O(1) worst-case
	 * runtime.
	 */
	@Override
	public E last() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("The list is empty");
		}
		return tail.getElement();
	}

	/**
	 * {@inheritDoc} For this singly-linked list, addLast(element) behavior has O(1)
	 * worst-case runtime. 
	 * 
	 * Citing Help from the Textbooks The code for this method
	 * is based on the addLast algorithm on page 297 in the course textbook "Data
	 * Structures and Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */

	@Override
	public void addLast(E element) {

		LinkedListNode<E> newest = new LinkedListNode<E>(element, null);
		if (isEmpty()) {
			front.next = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);
		LinkedListNode<E> current = front.next;

		for (int i = 0; i <= index - 1; i++) {
			current = current.next;
		}
		E temp = current.getElement();
		current.data = element;
		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		LinkedListNode<E> current = front.next;
		for (int i = 0; i <= index - 1; i++) {
			current = current.next;
		}
		return current.getElement();
	}

	private static class LinkedListNode<E> {

		/** element stored in node */
		private E data;

		/** next node in the list */
		private LinkedListNode<E> next;

		public LinkedListNode(E e) {
			setElement(e);
			setNext(null);
		}

		public LinkedListNode(E e, LinkedListNode<E> n) {
			setElement(e);
			setNext(n);
		}

		public LinkedListNode<E> getNext() {
			return next;
		}

		public E getElement() {
			return data;
		}

		public void setNext(LinkedListNode<E> n) {
			next = n;
		}

		public void setElement(E e) {
			data = e;
		}
	}

	private class ElementIterator implements Iterator<E> {
		/**
		 * Keep track of the next node that will be processed
		 */
		private LinkedListNode<E> current;

		/**
		 * Keep track of the node that was processed on the last call to 'next'
		 */
		private LinkedListNode<E> previous;

		/**
		 * Keep track of the previous-previous node that was processed so that we can
		 * update 'next' links when removing
		 */
		private LinkedListNode<E> previousPrevious;

		/**
		 * Keep track of whether it's ok to remove an element (based on whether next()
		 * has been called immediately before remove())
		 */
		private boolean removeOK;

		/**
		 * Construct a new element iterator where the cursor is initialized to the
		 * beginning of the list.
		 */
		public ElementIterator() {
			previousPrevious = front;
			previous = front;
			current = front.next;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E data = current.data;
			if (previousPrevious == previous) {
				previous = previous.next;
				current = current.next;
			} else {
				previousPrevious = previousPrevious.next;
				previous = previous.next;
				current = current.next;
			}
			removeOK = true;
			return data;
		}

		@Override
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			previousPrevious.next = current;
			previous = previousPrevious;
			if (!hasNext()) {
				tail = previousPrevious;
			}
			size--;
			removeOK = false;
		}
	}

}