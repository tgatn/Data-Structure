package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SplayTreeMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a splay tree data structure 
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class SplayTreeMapTest {

	/** BST map used for testing */
    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a splay tree-based map before each test case executes
     */     
    @Before
    public void setUp() {
        tree = new SplayTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        
        assertNull(tree.put(1, "one"));
        assertNull(tree.put(2, "two"));
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        assertNull(tree.put(3, "three"));
        assertEquals(3, (int)tree.root().getElement().getKey());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        assertNull(tree.put(5, "five"));
        assertEquals(5, (int)tree.root().getElement().getKey());
        assertEquals(3, (int)tree.left(tree.root()).getElement().getKey());
        assertNull(tree.put(4, "four"));
        assertEquals(4, (int)tree.root().getElement().getKey());
        assertEquals(3, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.right(tree.root()).getElement().getKey());  
    }
    
    /**
     * Test the output of the get(k) behavior
     */ 
    @Test
    public void testGet() {
    	assertNull(tree.put(1, "one"));
        assertNull(tree.put(2, "two"));
        assertNull(tree.put(3, "three"));
        assertNull(tree.put(5, "five"));
        assertNull(tree.put(4, "four"));
        assertEquals("two", tree.get(2)); 
        assertEquals(2, (int)tree.root().getElement().getKey());
        assertEquals(1, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(3, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals("four", tree.get(4));
        assertEquals(4, (int)tree.root().getElement().getKey());
        assertEquals(3, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.right(tree.root()).getElement().getKey()); 
        assertEquals("one", tree.get(1)); 
        assertEquals(1, (int)tree.root().getElement().getKey());
        assertEquals(4, (int)tree.right(tree.root()).getElement().getKey()); 
        
        assertNull(tree.get(10));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
    	assertNull(tree.put(1, "one"));
        assertNull(tree.put(2, "two"));
        assertNull(tree.put(3, "three"));
        assertNull(tree.put(5, "five"));
        assertNull(tree.put(4, "four"));
        assertEquals("two", tree.get(2)); 
        assertEquals("four", tree.get(4));
        assertEquals("one", tree.get(1)); 
        assertEquals("one", tree.remove(1));
        assertEquals("two", tree.remove(2));
        assertEquals(4, (int)tree.root().getElement().getKey());
        assertEquals(3, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.right(tree.root()).getElement().getKey()); 
    }
}