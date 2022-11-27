package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class for SearchTableMap
 * Checks the expected outputs of the Map abstract data type behaviors when using
 * a sorted array-based data structure that uses binary search to locate entries
 * based on the key of the entry
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class SkipListMapTest {
	
	/** map of integer and their associated string*/
    private Map<Integer, String> map;
    
    /** map of student and their associated integer */
    private Map<Student, Integer> studentMap;
    
    /** map of student id and their associated integer */
    private Map<Student, Integer> studentIdMap;
    
    /** student if comparator */
    private StudentIDComparator idComparator;
    
    /**
     * Create a new instance of a search table map before each test case executes
     */     
    @Before
    public void setUp() {
        map = new SkipListMap<Integer, String>();
        studentMap = new SkipListMap<Student, Integer>();
        studentIdMap = new SearchTableMap<Student, Integer>(idComparator);
    }

    /**
     * Test the output of the put(k,v) behavior
     */     
    @Test
    public void testPut() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertEquals("SkipListMap[3]", map.toString());
        assertEquals(1, map.size());
        
        assertNull(map.put(1, "string1"));
        assertNull(map.put(2, "string2"));
        
        assertEquals("SkipListMap[1, 2, 3]", map.toString());
        assertEquals(3, map.size());
        
        assertEquals("string3", map.put(3, "new3"));
    }

    /**
     * Test the output of the get(k) behavior
     */     
    @Test
    public void testGet() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
        assertEquals("string1", map.get(1));
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
        assertNull(map.get(10));
    }

    /**
     * Test the output of the remove(k) behavior
     */     
    @Test
    public void testRemove() {
        assertTrue(map.isEmpty());
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        assertFalse(map.isEmpty());
        assertEquals("SkipListMap[1, 2, 3, 4, 5]", map.toString());
        
        
        assertEquals("string1", map.remove(1));
        assertEquals("string3", map.remove(3));
        assertEquals("string5", map.remove(5));
        assertEquals("SkipListMap[2, 4]", map.toString());
        assertEquals(2, map.size());
        
        assertEquals("string2", map.remove(3));
        assertEquals("string4", map.remove(5));
        assertEquals(0, map.size());
        assertNull(map.remove(7));
    }
    
    /**
     * Tests Map abstract data type behaviors to ensure the behaviors work
     * as expected when using arbitrary objects as keys
     */
    @Test
    public void testStudentMap() {
    	Student s1 = new Student("J", "K", 1, 0, 0, "jk");
        Student s2 = new Student("J", "S", 2, 0, 0, "js");
        Student s3 = new Student("S", "H", 3, 0, 0, "sh");
        Student s4 = new Student("J", "J", 4, 0, 0, "jj");
        Student s5 = new Student("L", "B", 5, 0, 0, "lb");
        
        
        assertTrue(studentMap.isEmpty());
        assertNull(studentMap.put(s3, 3));
        assertNull(studentMap.put(s5, 5));
        assertNull(studentMap.put(s2, 2));
        assertNull(studentMap.put(s4, 4));
        assertNull(studentMap.put(s1, 1));
        assertFalse(studentMap.isEmpty());
        assertEquals(5, studentMap.size());
        
        assertEquals("1", studentMap.get(s1).toString());
        
        assertEquals("1", studentMap.remove(s1).toString());
        assertEquals(4, studentMap.size());
        
        assertTrue(studentIdMap.isEmpty());
        assertNull(studentIdMap.put(s3, 3));
        assertNull(studentIdMap.put(s5, 5));
        assertNull(studentIdMap.put(s2, 2));
        assertNull(studentIdMap.put(s4, 4));
        assertNull(studentIdMap.put(s1, 1));
        assertFalse(studentIdMap.isEmpty());
        assertEquals(5, studentIdMap.size());
        
        assertEquals("1", studentIdMap.get(s1).toString());
        
        assertEquals("1", studentIdMap.remove(s1).toString());
        assertEquals(4, studentIdMap.size());
    }
    
    /**
     * Test the output of the iterator behavior, including expected exceptions
     */ 
    @Test
    public void testIterator() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        assertEquals("1", map.iterator().next().toString());
		assertTrue(map.iterator().hasNext());
		assertThrows(UnsupportedOperationException.class, () -> map.iterator().remove());
    }

    /**
     * Test the output of the entrySet() behavior, including expected exceptions
     */     
    @Test
    public void testEntrySet() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        assertTrue(it.hasNext());
        Map.Entry<Integer, String> entry = it.next();
        assertEquals(1, (int)(entry.getKey()));
        assertEquals("string1", (String)(entry.getValue()));

        assertTrue(map.entrySet().iterator().hasNext());
		assertEquals("string1", map.entrySet().iterator().next().getValue());
		assertEquals("1", map.entrySet().iterator().next().getKey().toString());
		
		assertThrows(UnsupportedOperationException.class, () -> map.entrySet().iterator().remove());
    }

    /**
     * Test the output of the values() behavior, including expected exceptions
     */  
    @Test
    public void testValues() {
        assertNull(map.put(3, "string3"));
        assertNull(map.put(5, "string5"));
        assertNull(map.put(2, "string2"));
        assertNull(map.put(4, "string4"));
        assertNull(map.put(1, "string1"));
        
        Iterator<String> it = map.values().iterator();
        assertTrue(it.hasNext());
        
        assertEquals("string1", map.values().iterator().next());
		assertTrue(map.values().iterator().hasNext());
		assertThrows(UnsupportedOperationException.class, () -> map.values().iterator().remove());
    }
}