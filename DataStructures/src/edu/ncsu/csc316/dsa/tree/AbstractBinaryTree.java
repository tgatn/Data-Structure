package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.tree.AbstractTree.AbstractTreeNode;
import edu.ncsu.csc316.dsa.tree.AbstractTree.PositionCollection;

/**
 * A skeletal implementation of the Binary Tree abstract data type. This class
 * provides implementation for common methods that can be implemented the same
 * no matter what specific type of concrete data structure is used to implement
 * the binary tree abstract data type.
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <E> the type of elements stored in the binary tree
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    
	/**
	 * The code for this method is based on the inorder algorithm on page 342 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 */
	@Override
    public Iterable<Position<E>> inOrder() {
		PositionCollection traversal = new PositionCollection();
		if (!isEmpty()) {
			inOrderHelper(root(), traversal);
		}
		return traversal;
    }

	/**
	 * The code for this method is based on the inorderSubtree algorithm on page 342 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 * @param p is position of tree
	 * @param traversal snapshot of tree at certain iteration
	 */
    private void inOrderHelper(Position<E> p, PositionCollection traversal) {
        if (left(p) != null) {
        	inOrderHelper(left(p), traversal);
        }
        traversal.add(p);
        if (right(p) != null) {
        	inOrderHelper(right(p), traversal);
        }
    }
    
    /**
	 * The code for this method is based on the numChildren algorithm on page 320 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 */
    @Override
    public int numChildren(Position<E> p) {
    	int count = 0;
    	if (left(p) != null) {
    		count++;
    	}
    	if (right(p) != null) {
    		count++;
    	}
    	return count;
    }
    
    /**
	 * The code for this method is based on the sibling algorithm on page 320 in the
	 * course textbook "Data Structures and Algorithms" by Goodrich, Tamassia,
	 * Goldwasser.
	 */
    @Override
    public Position<E> sibling(Position<E> p) {
    	Position<E> parent = parent(p);
    	if (parent == null) {
    		return null;
    	}
    	if (p == left(parent)) {
    		return right(parent);
    	} else {
    		return left(parent);
    	}
    }
    
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        AbstractTreeNode<E> node = validate(p);
        PositionCollection childrenCollection = new PositionCollection();
        if (left(node) != null) {
            childrenCollection.add(left(node));
        }
        if (right(node) != null) {
            childrenCollection.add(right(node));
        }
        return childrenCollection;
    }
}