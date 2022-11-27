package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for BinarySearchTreeMap
 * Checks the expected outputs of the Map and Tree abstract data type behaviors when using
 * an linked binary tree data structure 
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class BinarySearchTreeMapTest {
	
	/** BST map of strings*/
    private BinarySearchTreeMap<Integer, String> tree;
    
    /**
     * Create a new instance of a binary search tree map before each test case executes
     */
    @Before
    public void setUp() {
        tree = new BinarySearchTreeMap<Integer, String>();
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        tree.put(10, "ten");
        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(10, (int)tree.root().getElement().getKey());
        
        assertEquals(null, tree.put(2, "two"));
        assertEquals(2, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(2, (int)tree.left(tree.root()).getElement().getKey());
        
        assertEquals(null, tree.put(12, "twelve"));
        assertEquals(3, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(12, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals("twelve", tree.right(tree.root()).getElement().getValue());
        
        assertEquals("twelve", tree.put(12, "twelveNew"));
        assertEquals(3, tree.size());
        assertFalse(tree.isEmpty());
        assertEquals(12, (int)tree.right(tree.root()).getElement().getKey());
        assertEquals("twelveNew", tree.right(tree.root()).getElement().getValue());
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        assertEquals("one", tree.get(1));
        
        tree.put(-2,  "-two");
        assertEquals(2, tree.size());
        assertEquals("-two", tree.get(-2));
        
        assertNull(tree.get(10));
        
        tree.put(-1,  "-one");
        tree.restructure(tree.right(tree.left(tree.root())));
        
        assertEquals(3, tree.size());
        assertEquals(-1, (int)tree.root().getElement().getKey());
        assertEquals(1, (int)tree.right(tree.root()).getElement().getKey());
    }

    /**
     * Test the output of the remove(k) behavior
     */ 
    @Test
    public void testRemove() {
        tree.put(1,  "one");
        assertEquals(1, tree.size());
        
        assertNull(tree.remove(10));
        assertEquals(1, tree.size());
        
        assertEquals("one", tree.remove(1));
        assertEquals(0, tree.size());
        
        //            8
        //            /\
        //          5    9
        //         /  \    \
        //        3   6      10
        //           /
        //          4
        assertEquals(null, tree.put(8, "eight"));
        assertEquals(null, tree.put(9, "nine"));
        assertEquals(null, tree.put(10, "ten"));
        assertEquals(null, tree.put(3, "three"));
        assertEquals(null, tree.put(5, "five"));
        assertEquals(null, tree.put(4, "four"));
        assertEquals(null, tree.put(6, "six"));
        assertEquals(7, tree.size());
        
        //
        //            9
        //            /\
        //          5    10
        //         /  \    
        //        3   6      
        //           /
        //          4
        
        assertEquals("eight", tree.remove(8));
        assertEquals("nine", tree.root().getElement().getValue());
        assertEquals("three", tree.remove(3));
        assertEquals("four", tree.remove(4));
        assertEquals("ten", tree.remove(10));
        assertEquals("five", tree.remove(5));
        
        tree.put(5, "five");
        //
        //            9
        //            /
        //          6 
        //         /
        //        5
        assertEquals(3, tree.size());
        assertEquals(6, (int)tree.left(tree.root()).getElement().getKey());
        assertEquals(5, (int)tree.left(tree.left(tree.root())).getElement().getKey());
        tree.restructure(tree.left(tree.left(tree.root())));
        
       assertEquals(6, (int)tree.root().getElement().getKey());
       tree.put(8, "eight");
       tree.restructure(tree.left(tree.right(tree.root())));
       
       assertEquals(8, (int)tree.root().getElement().getKey());
       assertEquals(9, (int)tree.right(tree.root()).getElement().getKey());
        
    }
}