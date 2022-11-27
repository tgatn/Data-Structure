package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

	/** A dummy/sentinel node representing at the front of the list **/
	private PositionalNode<E> front;

	/** A dummy/sentinel node representing at the end/tail of the list **/
	private PositionalNode<E> tail;

	/** The number of elements in the list **/
	private int size;

	/**
	 * Constructs an empty positional linked list
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) {
		PositionalNode<E> node = validate(p);
		return addBetween(e, node.getNext(), node);
	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * addBefore algorithm on page 279 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
	@Override
	public Position<E> addBefore(Position<E> p, E e) {

		PositionalNode<E> node = validate(p);
		return addBetween(e, node, node.getPrevious());
	}

	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, front.getNext(), front);

	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, tail, tail.getPrevious());
	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * position algorithm on page 278 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 * 
	 * @param node is node of position to finds
	 * 
	 * @return position of node
	 */
	private Position<E> position(PositionalNode<E> node) {
		if (node == front || node == tail) {
			return null;
		}
		return node;
	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the after
	 * algorithm on page 278 in the course textbook "Data Structures and Algorithms"
	 * by Goodrich, Tamassia, Goldwasser.
	 */
	@Override
	public Position<E> after(Position<E> p) {

		PositionalNode<E> node = validate(p);
		return position(node.getNext());
	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * before algorithm on page 278 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
	@Override
	public Position<E> before(Position<E> p) {

		PositionalNode<E> node = validate(p);
		return position(node.getPrevious());
	}

	@Override
	public Position<E> first() {
		if (size == 0) {
			return null;
		} else {
			return front.getNext();
		}

	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<E> last() {
		if (size == 0) {
			return null;
		} else {
			return tail.getPrevious();
		}
	}

	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * remove algorithm on page 280 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
	@Override
	public E remove(Position<E> p) {

		PositionalNode<E> node = validate(p);
		PositionalNode<E> prev = node.getPrevious();
		PositionalNode<E> next = node.getNext();
		prev.setNext(next);
		next.setPrevious(prev);
		size--;
		E ans = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrevious(null);
		return ans;
	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the set
	 * algorithm on page 279 in the course textbook "Data Structures and Algorithms"
	 * by Goodrich, Tamassia, Goldwasser.
	 */
	@Override
	public E set(Position<E> p, E e) {

		PositionalNode<E> node = validate(p);
		E ans = node.getElement();
		node.setElement(e);
		return ans;
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Safely casts a Position, p, to be a PositionalNode.
	 * 
	 * @param p the position to cast to a PositionalNode
	 * @return a reference to the PositionalNode
	 * @throws IllegalArgumentException if p is null, or if p is not a valid
	 *                                  PositionalNode
	 */
	private PositionalNode<E> validate(Position<E> p) {
		if (p instanceof PositionalNode) {
			return (PositionalNode<E>) p;
		}
		throw new IllegalArgumentException("Position is not a valid positional list node.");
	}

	private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {

		PositionalNode<E> newest = new PositionalNode<>(element, next, prev);
		prev.setNext(newest);
		next.setPrevious(newest);

		size++;
		return newest;
	}

	private static class PositionalNode<E> implements Position<E> {

		/** element stored at a node */
		private E element;

		/** next node in the list */
		private PositionalNode<E> next;

		/** previous node in the list */
		private PositionalNode<E> previous;

		public PositionalNode(E value) {
			this(value, null);
		}

		public PositionalNode(E value, PositionalNode<E> next) {
			this(value, next, null);
		}

		public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
			setElement(value);
			setNext(next);
			setPrevious(prev);
		}

		public void setPrevious(PositionalNode<E> prev) {
			previous = prev;
		}

		public PositionalNode<E> getPrevious() {
			return previous;
		}

		public void setNext(PositionalNode<E> next) {
			this.next = next;
		}

		public PositionalNode<E> getNext() {
			return next;
		}

		@Override
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
	}

	/**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * PositionIterator class on page 287 in the course textbook "Data Structures
	 * and Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
	private class PositionIterator implements Iterator<Position<E>> {

		/** position of current node */
		private Position<E> current;

		/** indicates if it is okay to remove a node */
		private boolean removeOK;

		public PositionIterator() {
			current = front.next;
		}

		@Override
		public boolean hasNext() {
			if (current == null) {
				return false;
			}
			return validate(current).next != null;
		}

		@Override
		public Position<E> next() {
			if (validate(current).next == null) {
				throw new NoSuchElementException();
			}

			Position<E> ret = current;
			current = validate(current).next;
			removeOK = true;
			return ret;
		}

		@Override
		public void remove() {
			if (removeOK) {
				Position<E> before = before(current);
				PositionalLinkedList.this.remove(before);
				before = null;
				removeOK = false;
			} else {
				throw new IllegalStateException();
			}

		}
	}

	private class ElementIterator implements Iterator<E> {

		/** instance of iterator */
		private Iterator<Position<E>> it;

		public ElementIterator() {
			it = new PositionIterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public E next() {
			return it.next().getElement();
		}

		@Override
		public void remove() {
			it.remove();
		}
	}

	private class PositionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}
}