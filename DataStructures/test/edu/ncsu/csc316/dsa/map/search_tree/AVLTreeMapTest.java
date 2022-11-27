package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for AVLTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * an AVL tree data structure 
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class AVLTreeMapTest {

	/** BST map used for testing */
    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of an AVL tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new AVLTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        assertEquals(1, (int)tree.root().getElement().getKey());
        tree.put(2, "two");
        assertEquals(2, (int)tree.right(tree.root()).getElement().getKey());
        tree.put(-1, "-one");
        tree.put(3, "three");
        
        //single rotation on right
        tree.restructure(tree.right(tree.right(tree.root())));
        assertEquals(2, (int)tree.root().getElement().getKey());
        
        //single rotation on left
        tree.restructure(tree.left(tree.left(tree.root())));
        assertEquals(1, (int)tree.root().getElement().getKey());
        assertEquals(2, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(3, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(-1, (int)tree.left(tree.root()).getElement().getKey());
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        tree.put(1, "one");
        tree.put(2, "two");
        tree.put(-1, "-one");
        tree.put(3, "three");
        
        //single rotation on right
        tree.restructure(tree.right(tree.right(tree.root())));
        
        //single rotation on left
        tree.restructure(tree.left(tree.left(tree.root())));
        
        assertNull(tree.get(10));
        assertEquals("one", tree.get(1));
        assertEquals("-one", tree.get(-1));
        assertEquals("two", tree.get(2));
        assertEquals("three", tree.get(3));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(tree.isEmpty());
        tree.put(1, "one");
        tree.put(5, "five");
        tree.put(3, "three");
       
        //double rotation right
        assertEquals(3, (int)tree.root().getElement().getKey());
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.right(tree.root()).getElement().getKey());
        
        //double rotation left
        tree.put(2, "two");
        tree.restructure(tree.right(tree.left(tree.root())));
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertEquals(3, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.right(tree.right(tree.root())).getElement().getKey());
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        
        assertEquals("three", tree.remove(3));
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertNull(tree.remove(10));   
    }
}