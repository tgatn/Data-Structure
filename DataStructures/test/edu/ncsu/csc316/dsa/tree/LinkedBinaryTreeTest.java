package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.Position;

/**
 * Test class for LinkedBinaryTree
 * Checks the expected outputs of the BinaryTree abstract data type behaviors when using
 * a linked data structure to store elements
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class LinkedBinaryTreeTest {
	
	/** linked binary tree */
    private LinkedBinaryTree<String> tree;
    
    /** position one */
    private Position<String> one;
    
    /** position two */
    private Position<String> two;
    
    /** position three */
    private Position<String> three;
    
    /** position four */
    private Position<String> four;
    
    /** position five */
    private Position<String> five;
    
    /** position six */
    private Position<String> six;
    
    /** position seven */
    private Position<String> seven;

    /** position eight */
    private Position<String> eight;
    
    /** position nine */
    private Position<String> nine;
    
    /** position ten */
    private Position<String> ten;
    
//    /**
//     * Helper class to create an invalid position to help test validate(p)
//     */
//    private class InvalidPosition<E> implements Position<E> {
//
//        @Override
//        public E getElement() {
//            return null;
//        }
//        
//    }

    /**
     * Create a new instance of a linked binary tree before each test case executes
     */       
    @Before
    public void setUp() {
        tree = new LinkedBinaryTree<String>(); 
    }
    
    /**
     * Sample tree to help with testing
     *
     * One
     * -> Two
     *   -> Six
     *   -> Ten
     *     -> Seven
     *     -> Five
     * -> Three
     *   -> Four
     *     -> Eight
     *     -> Nine
     * 
     * Or, visually:
     *                    one
     *                /        \
     *             two          three
     *            /   \            /
     *         six   ten          four
     *              /   \        /     \
     *            seven  five  eight nine    
     */  
    private void createTree() {
        one = tree.addRoot("one");
        two = tree.addLeft(one, "two");
        three = tree.addRight(one, "three");
        six = tree.addLeft(two, "six");
        ten = tree.addRight(two, "ten");
        four = tree.addLeft(three, "four");
        seven = tree.addLeft(ten, "seven");
        five = tree.addRight(ten, "five");
        eight = tree.addLeft(four, "eight");
        nine = tree.addRight(four, "nine");
    }
    
    /**
     * Test the output of the set(p,e) behavior
     */     
    @Test
    public void testSet() {
        createTree();
        Position<String> invalid = null;
        assertThrows(IllegalArgumentException.class, () -> tree.set(invalid, "1"));
        assertEquals("nine", tree.right(four).getElement());
        assertEquals("nine", tree.set(nine, "9"));
        assertEquals("9", tree.right(four).getElement());
    }
    
    /**
     * Test the output of the size() behavior
     */     
    @Test
    public void testSize() {
        assertTrue(tree.isEmpty());
        createTree();
        assertEquals(10, tree.size());
    }
    
    /**
     * Test the output of the numChildren(p) behavior
     */     
    @Test
    public void testNumChildren() {
        createTree();
        assertEquals(0, tree.numChildren(five));
        assertEquals(1, tree.numChildren(three));
        assertEquals(2, tree.numChildren(ten));
    }

    /**
     * Test the output of the parent(p) behavior
     */   
    @Test
    public void testParent() {
        createTree();
        Position<String> invalid = null;
        assertThrows(IllegalArgumentException.class, () -> tree.parent(invalid));
        assertEquals(ten, tree.parent(seven));
    }

    /**
     * Test the output of the sibling behavior
     */     
    @Test
    public void testSibling() {
        createTree();
        assertNull(tree.sibling(one));
        assertEquals(three, tree.sibling(two));
        assertEquals(eight, tree.sibling(nine));
    }

    /**
     * Test the output of the isInternal behavior
     */     
    @Test
    public void testIsInternal() {
        createTree();
        assertTrue(tree.isInternal(one));
        assertFalse(tree.isInternal(seven));
        assertTrue(tree.isInternal(ten));
    }

    /**
     * Test the output of the isLeaf behavior
     */     
    @Test
    public void isLeaf() {
        createTree();
        assertFalse(tree.isLeaf(one));
        assertTrue(tree.isLeaf(seven));
        assertFalse(tree.isLeaf(ten));
    }

    /**
     * Test the output of the isRoot(p)
     */     
    @Test
    public void isRoot() {
        createTree();
        assertTrue(tree.isRoot(one));
        assertFalse(tree.isRoot(seven));
        assertFalse(tree.isRoot(six));
        assertThrows(IllegalArgumentException.class, () -> tree.addRoot("test"));
        assertEquals(seven, tree.setRoot(seven));
        assertFalse(tree.isRoot(one));
        assertTrue(tree.isRoot(seven));
    }
    
    /**
     * Test the output of the preOrder traversal behavior
     */     
    @Test
    public void testPreOrder() {
        createTree();
        Iterator<Position<String>> test = tree.preOrder().iterator();
        assertEquals(one, test.next());
        assertEquals(two, test.next());
        assertEquals(six, test.next());
        assertEquals(ten, test.next());
        assertEquals(seven, test.next());
        assertEquals(five, test.next());
        assertEquals(three, test.next());
        assertEquals(four, test.next());
        assertEquals(eight, test.next());
        assertEquals(nine, test.next());
    }

    /**
     * Test the output of the postOrder traversal behavior
     */     
    @Test
    public void testPostOrder() {
        createTree();
        Iterator<Position<String>> test = tree.postOrder().iterator();
        assertEquals(six, test.next());
        assertEquals(seven, test.next());
        assertEquals(five, test.next());
        assertEquals(ten, test.next());
        assertEquals(two, test.next());
        assertEquals(eight, test.next());
        assertEquals(nine, test.next());
        assertEquals(four, test.next());
        assertEquals(three, test.next());
        assertEquals(one, test.next());
    }
    
    /**
     * Test the output of the inOrder traversal behavior
     */     
    @Test
    public void testInOrder() {
        createTree();
        Iterator<Position<String>> test = tree.inOrder().iterator();
        assertEquals(six, test.next());
        assertEquals(two, test.next());
        assertEquals(seven, test.next());
        assertEquals(ten, test.next());
        assertEquals(five, test.next());
        assertEquals(one, test.next());
        assertEquals(eight, test.next());
        assertEquals(four, test.next());
        assertEquals(nine, test.next());
        assertEquals(three, test.next());
    }

    /**
     * Test the output of the Binary Tree ADT behaviors on an empty tree
     */     
    @Test
    public void testEmptyTree() {
        assertTrue(tree.isEmpty());
    }
    
    /**
     * Test the output of the levelOrder traversal behavior
     */ 
    @Test
    public void testLevelOrder() {
    	createTree();
        Iterator<Position<String>> test = tree.levelOrder().iterator();
        assertEquals(one, test.next());
        assertEquals(two, test.next());
        assertEquals(three, test.next());
        assertEquals(six, test.next());
        assertEquals(ten, test.next());
        assertEquals(four, test.next());
        assertEquals(seven, test.next());
        assertEquals(five, test.next());
        assertEquals(eight, test.next());
        assertThrows(UnsupportedOperationException.class, () -> test.remove());
        assertEquals(nine, test.next());
    }

    /**
     * Test the output of the addLeft(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddLeft() {
    	createTree();
    	assertEquals(six, tree.left(two));
    	assertThrows(IllegalArgumentException.class, () -> tree.addLeft(two, "test"));
    	
    }
    
    /**
     * Test the output of the addRight(p,e) behavior, including expected exceptions
     */      
    @Test
    public void testAddRight() {
    	createTree();
    	assertEquals(five, tree.right(ten));
    	assertThrows(IllegalArgumentException.class, () -> tree.addRight(ten, "test"));
    	
    }   
    
    /**
     * Test the output of the remove(p) behavior, including expected exceptions
     */         
    @Test
    public void testRemove() {
        createTree();
        assertThrows(IllegalArgumentException.class, () -> tree.remove(one));
        assertEquals(seven.getElement(), tree.remove(seven));
        assertEquals(five.getElement(), tree.remove(five));
        assertEquals(0, tree.numChildren(ten));
        assertEquals(ten.getElement(), tree.remove(ten));
        assertEquals(two.getElement(), tree.remove(two));
        assertEquals(six, tree.left(one));
        assertEquals(six.getElement(), tree.remove(six));
        assertEquals(one.getElement(), tree.remove(one));
        assertEquals(three, tree.root());
    }
    
    /**
     * Test the output of toString
     */
    @Test
    public void testToString() {
    	createTree();
    	assertEquals("LinkedBinaryTree[\n"
        		+ "one\n"
        		+ " two\n"
        		+ "  six\n"
        		+ "  ten\n"
        		+ "   seven\n"
        		+ "   five\n"
        		+ " three\n"
        		+ "  four\n"
        		+ "   eight\n"
        		+ "   nine\n"
        		+ "]", tree.toString());
    }
}