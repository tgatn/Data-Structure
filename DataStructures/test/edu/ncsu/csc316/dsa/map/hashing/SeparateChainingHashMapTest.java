package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for SeparateChainingHashMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a separate chaining hash map data structure 
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class SeparateChainingHashMapTest {

	/** map used for testing */
    private Map<Integer, String> map;
    
    /** map used for testing */
    private Map<Integer, String> map2;
    
    /** map used for testing */
    private Map<Integer, String> map3;
    
    /** map used for testing */
    private Map<Integer, String> map4;
    
    /**
     * Create a new instance of a separate chaining hash map before each test case executes
     */     
    @Before
    public void setUp() {
        // Use the "true" flag to indicate we are TESTING.
        // Remember that (when testing) alpha = 1, beta = 1, and prime = 7
        // based on our AbstractHashMap constructor.
        // That means you can draw the hash table by hand
        // if you use integer keys, since Integer.hashCode() = the integer value, itself
        // Finally, apply compression. For example:
        // for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
        // for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
        // for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
        // for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
        // for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
        // for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
        // etc.
        // Remember that our secondary map (an AVL tree) is a search
        // tree, which means the entries should be sorted in order within
        // that tree
        map = new SeparateChainingHashMap<Integer, String>(7, true);
        map2 = new SeparateChainingHashMap<Integer, String>();
        map3 = new SeparateChainingHashMap<Integer, String>(true);
        map4 = new SeparateChainingHashMap<Integer, String>(7);
    }
    
    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map2.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));

        // Since our entrySet method returns the entries in the table
        // from left to right, we can use the entrySet to check
        // that our values are in the correct order in the hash table.
        // Alternatively, you could implement a toString() method if you
        // want to check that the exact index/map of each bucket is correct
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        
        
        assertNull(map.put(4, "string4"));
        assertEquals(2, map.size());
        assertFalse(map.isEmpty());
        it = map.entrySet().iterator();
        assertEquals(3, (int)it.next().getKey()); // should be in a map in index 4
        assertEquals(4, (int)it.next().getKey()); // should be in a map in index 5
        
        // You should create some collisions to check that entries
        // are placed in the correct buckets
        assertNull(map.put(2, "string2"));
        assertEquals("string3", map.put(3, "newString3"));
        assertNull(map.put(7, "string7"));
        it = map.entrySet().iterator();
        assertEquals("string7", it.next().getValue());
        assertEquals("string2", it.next().getValue());
        assertEquals("newString3", it.next().getValue());
        assertEquals(4, (int)it.next().getKey());
        
    }
    
    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map3.isEmpty());
        assertNull(map.get(10));
        assertNull(map.put(3, "string3")); // 4
        assertNull(map.put(4, "string4")); // 5
        assertNull(map.put(5, "string5")); // 6
        assertNull(map.put(6, "string6")); // 0
        assertEquals("string6", map.get(6));
    }
    
    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map4.isEmpty());
        assertNull(map.remove(10));
        assertNull(map.put(3, "string3")); // 4
        assertNull(map.put(4, "string4")); // 5
        assertNull(map.put(5, "string5")); // 6
        assertNull(map.put(6, "string6")); // 0
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertEquals("string6", it.next().getValue());
        assertEquals("string3", it.next().getValue());
        assertEquals("string4", it.next().getValue());
        assertEquals("string5", it.next().getValue());
        assertEquals(4, map.size());
        assertEquals("string4", map.remove(4));
        assertEquals("string6", map.remove(6));
        Iterator<Map.Entry<Integer, String>> it2 = map.entrySet().iterator();
        assertEquals(2, map.size());
        assertEquals("string3", it2.next().getValue());
        assertEquals("string5", it2.next().getValue());
    }
    
    /**
     * Test the output of the iterator() behavior, including expected exceptions
     */   
    @Test
    public void testIterator() {
    	assertNull(map.put(3, "string3")); // 4
        assertNull(map.put(4, "string4")); // 5
        assertNull(map.put(5, "string5")); // 6
        assertNull(map.put(6, "string6")); // 0
        
        Iterator<Integer> it = map.iterator();
        assertEquals("6", it.next().toString());
        assertEquals("3", it.next().toString());
        assertEquals("4", it.next().toString());
        assertEquals("5", it.next().toString());
        assertThrows(UnsupportedOperationException.class, () -> it.remove());
    }
    
    /**
     * Test the output of the entrySet() behavior
     */   
    @Test
    public void testEntrySet() {
    	assertNull(map.put(3, "string3")); // 4
        assertNull(map.put(4, "string4")); // 5
        assertNull(map.put(5, "string5")); // 6
        assertNull(map.put(6, "string6")); // 0
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();        
        assertEquals("string6", it.next().getValue());
        assertEquals("string3", it.next().getValue());
        assertEquals("string4", it.next().getValue());
        assertEquals("string5", it.next().getValue());
    }
    
    /**
     * Test the output of the values() behavior
     */   
    @Test
    public void testValues() {
    	assertNull(map.put(3, "string3")); // 4
        assertNull(map.put(4, "string4")); // 5
        assertNull(map.put(5, "string5")); // 6
        assertNull(map.put(6, "string6")); // 0
        
        Iterator<String> it = map.values().iterator();
        assertEquals("string6", it.next());
        assertEquals("string3", it.next());
        assertEquals("string4", it.next());
        assertEquals("string5", it.next());
    }
}