package edu.ncsu.csc316.dsa.disjoint_set;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;

/**
 * The UpTreeDisjointSetForest is implemented as a forest of linked up-trees.
 * Using balanced union, union has worst-case runtime of O(1). Using
 * path-compression find, find has worst-case O(logn), but over time has
 * worst-case runtime O(log*(n)) [log-star].
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <E> the type of elements stored in the disjoint set
 */
public class UpTreeDisjointSetForest<E> implements DisjointSetForest<E> {

	// We need a secondary map to quickly locate an entry within the forest of
	// up-trees
	// NOTE: The textbook implementation does not include this
	// functionality; instead, the textbook implementation leaves
	// the responsibility of tracking positions to the client in a
	// separate map structure
	/** map of up tree nodes */
	private Map<E, UpTreeNode<E>> map;

	/**
	 * Constructs a new DisjointSetForest
	 */
	public UpTreeDisjointSetForest() {
		// Use an efficient map!
		map = new LinearProbingHashMap<E, UpTreeNode<E>>();
	}

	/**
	 * An UpTreeNode maintains an element, a reference to the node's parent, and (if
	 * it's the root of an up-tree) the number of nodes stored within that up-tree.
	 * 
	 * @author Dr. King
	 *
	 * @param <E> is generic type E
	 */
	private static class UpTreeNode<E> implements Position<E> {

		/** generic element e */
		private E element;

		/** parent of a node */
		private UpTreeNode<E> parent;

		/** number of elements */
		private int count;

		/**
		 * Constructs a new UpTreeNode with the given element, a reference to itself as
		 * the parent, and a count of 1.
		 * 
		 * @param element the element to store in the new UpTreeNode
		 */
		public UpTreeNode(E element) {
			setElement(element);
			setParent(this);
			setCount(1);
		}

		/**
		 * Sets the element of the UpTreeNode to the given element
		 * 
		 * @param element the element to store in the UpTreeNode
		 */
		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public E getElement() {
			return element;
		}

		/**
		 * Sets the parent of the UpTreeNode to the given UpTreeNode
		 * 
		 * @param parent the UpTreeNode to set as the current node's parent
		 */
		public void setParent(UpTreeNode<E> parent) {
			this.parent = parent;
		}

		/**
		 * Returns a reference to the parent of the current UpTreeNode
		 * 
		 * @return a reference to the parent of the current UpTreeNode
		 */
		public UpTreeNode<E> getParent() {
			return parent;
		}

		/**
		 * Sets the number of nodes contained in the UpTree rooted at the current
		 * UpTreeNode
		 * 
		 * @param count is the number of nodes
		 */
		public void setCount(int count) {
			this.count = count;
		}

		/**
		 * If the current UpTreeNode is the root of an up-tree, returns the number of
		 * elements stored within the UpTree. Otherwise, if the current UpTreeNode is
		 * not the root of an up-tree, count is undefined.
		 * 
		 * @return the number of elements stored within the UpTree, if the current
		 *         UpTreeNode is the root; otherwise, count is undefined.
		 */
		public int getCount() {
			return count;
		}
	}

	@Override
	public Position<E> makeSet(E value) {
		UpTreeNode<E> ret = new UpTreeNode<>(value);
		map.put(value, ret);
		return ret;
	}

	@Override
	public Position<E> find(E value) {
		// NOTE: The textbook solution requires the client to keep
		// track of the location of each position in the forest.
		// Our implementation includes a Map to handle this for the
		// client, so we should allow the client to find the set
		// that contains a node by specifying the element

		UpTreeNode<E> ret = map.get(value);
		if (ret == null) {
			return null;
		}
		return findHelper(ret);

	}

	private UpTreeNode<E> findHelper(UpTreeNode<E> current) {
		// Implement path-compression find
		// This method is based on the pseudocode given in Lecture 18, slides 63 of
		// CSC316
		UpTreeNode<E> ret = current;
		if (ret != ret.getParent()) {
			ret.setParent((UpTreeNode<E>) findHelper(ret.getParent()));
		}
		return ret.getParent();
	}

	@Override
	public void union(Position<E> s, Position<E> t) {
		/*
		 * Citing Help from the Textbooks The code for this method is based on the
		 * union algorithm on page 676 in the course textbook
		 * "Data Structures and Algorithms" by Goodrich, Tamassia, Goldwasser.
		 */
		UpTreeNode<E> a = validate(s);
		UpTreeNode<E> b = validate(t);
		if (a != b) {
			if (a.getCount() > b.getCount()) {
				b.parent = a;
				a.count += b.count;
			} else {
				a.parent = b;
				b.count += a.count;
			}
		}
	}

	private UpTreeNode<E> validate(Position<E> p) {
		if (!(p instanceof UpTreeNode)) {
			throw new IllegalArgumentException("Position is not a valid up tree node.");
		}
		return (UpTreeNode<E>) p;
	}
}