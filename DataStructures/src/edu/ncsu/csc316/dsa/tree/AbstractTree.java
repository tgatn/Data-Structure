package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;

/**
 * A skeletal implementation of the Tree abstract data type. This class provides
 * implementation for common methods that can be implemented the same no matter
 * what specific type of concrete data structure is used to implement the tree
 * abstract data type.
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <E> the type of elements stored in the tree
 */
public abstract class AbstractTree<E> implements Tree<E> {

	@Override
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	@Override
	public boolean isLeaf(Position<E> p) {
		return numChildren(p) == 0;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * The code for this method is based on the set algorithm on page 328 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 */
	@Override
	public E set(Position<E> p, E value) {
		AbstractTreeNode<E> node = this.validate(p);
		E ret = node.getElement();
		node.setElement(value);
		return ret;
	}

	@Override
	public Iterable<Position<E>> preOrder() {
		PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
            preOrderHelper(root(), traversal);
        }
        return traversal;
	}
	
	private void preOrderHelper(Position<E> p, PositionCollection traversal) {
        traversal.add(p);
        for (Position<E> c : children(p)) {
            preOrderHelper(c, traversal);
        }
    }

	/**
	 * The code for this method is based on the postOrder algorithm on page 341 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 */
	@Override
	public Iterable<Position<E>> postOrder() {
		PositionCollection traversal = new PositionCollection();
        if (!isEmpty()) {
        	postOrderHelper(root(), traversal);
        }
        return traversal; 
	}
	
	/**
	 * The code for this method is based on the postorderSubtree algorithm on page 341 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 * @param p is position in tree
	 * @param traversal snapshot of tree at certain iteration
	 */
	private void postOrderHelper(Position<E> p, PositionCollection traversal) {
        for (Position<E> c : children(p)) {
        	postOrderHelper(c, traversal);
        }
        traversal.add(p);
    }

	/**
	 * The code for this method is based on the breadthfirst algorithm on page 342 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 */
	@Override
	public Iterable<Position<E>> levelOrder() {
		PositionCollection traversal = new PositionCollection();
		if (!isEmpty()) {
			ArrayBasedQueue<Position<E>> fringe = new ArrayBasedQueue<>();
			fringe.enqueue(root());
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue();
				traversal.add(p);
				for (Position<E> c : children(p)) {
					fringe.enqueue(c);
				}
			}
		}
		return traversal;
	}

	/**
	 * Safely casts a Position, p, to be an AbstractTreeNode.
	 * 
	 * @param p the position to cast to a AbstractTreeNode
	 * @return a reference to the AbstractTreeNode
	 * @throws IllegalArgumentException if p is null, or if p is not a valid
	 *                                  AbstractTreeNode
	 */
	protected abstract AbstractTreeNode<E> validate(Position<E> p);

	protected abstract static class AbstractTreeNode<E> implements Position<E> {

		/** generic element e */
		private E element;

		public AbstractTreeNode(E element) {
			setElement(element);
		}

		@Override
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[\n");
		toStringHelper(sb, "", root());
		sb.append("]");
		return sb.toString();
	}

	private void toStringHelper(StringBuilder sb, String indent, Position<E> root) {
		if (root == null) {
			return;
		}
		sb.append(indent).append(root.getElement()).append("\n");
		for (Position<E> child : children(root)) {
			toStringHelper(sb, indent + " ", child);
		}
	}
	
    /**
     * PositionCollection implements the {@link Iterable} interface to allow traversing
     * through the positions of the tree. PositionCollection does not allow removal
     * operations
     * 
     * @author Dr. King
     *
     */
    protected class PositionCollection implements Iterable<Position<E>> {

    	/** list of positions for a tree */
        private List<Position<E>> list;

        /**
         * Construct a new PositionCollection
         */
        public PositionCollection() {
            list = new SinglyLinkedList<Position<E>>();
        }

        /**
         * Add a position to the collection. Null positions or positions with null
         * elements are not added to the collection
         * 
         * @param position the position to add to the collection
         */
        public void add(Position<E> position) {
            if (position != null && position.getElement() != null) {
                list.addLast(position);
            }
        }

        /**
         * Return an iterator for the PositionCollection
         * @return iterator for PositionCollection
         */
        public Iterator<Position<E>> iterator() {
            return new PositionSetIterator();
        }

        private class PositionSetIterator implements Iterator<Position<E>> {

        	/** iterator for trees */
            private Iterator<Position<E>> it;

            public PositionSetIterator() {
                it = list.iterator();
            }

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Position<E> next() {
                return it.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("The remove operation is not supported yet.");
            }
        }
    }
}