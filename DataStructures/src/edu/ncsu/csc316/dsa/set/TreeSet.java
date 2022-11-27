package edu.ncsu.csc316.dsa.set;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.search_tree.AVLTreeMap;

/**
 * The TreeSet is implemented as a AVL tree data structure to support efficient
 * set abstract data type behaviors.
 * 
 * Using a [DATA STRUCTURE TYPE YOU CHOSE] tree ensures worst-case runtime of
 * O(logn) for add, remove, and contain; O(nlogn) worst-case runtime for addAll,
 * removeAll, and retainAll; and O(1) worst-case runtime for size and isEmpty.
 * 
 * The TreeSet class is based on the implementation developed for use with the
 * textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <E> the type of elements stored in the set
 */
public class TreeSet<E extends Comparable<E>> extends AbstractSet<E> {
	// Since we will delegate to an existing balanced search tree, the entries will
	// be ordered.
	// As a result, we must also restrict our tree set to use Comparable elements.

	/** map of elements used with tree */
	private Map<E, E> tree;

	/**
	 * Constructs a new TreeSet
	 */
	public TreeSet() {
		tree = new AVLTreeMap<>();
	}

	@Override
	public Iterator<E> iterator() {
		return tree.iterator();
	}

	@Override
	public void add(E value) {
		tree.put(value, value);
	}

	@Override
	public boolean contains(E value) {
		return tree.get(value) != null;
	}

	@Override
	public E remove(E value) {
		if (contains(value)) {
			E temp = value;
			tree.remove(value);
			return temp;
		} else {
			return null;
		}
		
	}

	@Override
	public int size() {
		return tree.size();
	}
}