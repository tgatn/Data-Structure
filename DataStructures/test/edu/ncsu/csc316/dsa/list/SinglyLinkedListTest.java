package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SinglyLinkedList.
 * Checks the expected outputs of the List abstract data type behaviors when using
 * an linked list data structure
 *
 * @author Dr. King
 *
 */
public class SinglyLinkedListTest {

	/** list of strings */
    private List<String> list;
    

    /**
     * Create a new instance of an array-based list before each test case executes
     */
    @Before
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }

    /**
     * Test the output of the add(index, e) behavior, including expected exceptions
     */
    @Test
    public void testAddIndex() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        
        // Use the statements above to help guide your test cases
        // for data structures: Start with an empty data structure, then
        // add an element and check the accessor method return values.
        // Then add another element and check again. Continue to keep checking
        // for special cases. For example, for an array-based list, you should
        // continue adding until you trigger a resize operation to make sure
        // the resize operation worked as expected.
        
        try{
            list.add(15,  "fifteen");
            fail("An IndexOutOfBoundsException should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
        
        list.add(0, "a");
        assertEquals(1, list.size());
        assertEquals("a", list.get(0));
        assertFalse(list.isEmpty());
        list.add(1, "b");
        assertEquals(2, list.size());
        assertEquals("b", list.get(1));
        assertFalse(list.isEmpty());
        list.add(1, "c");
        assertEquals(3, list.size());
        assertEquals("c", list.get(1));
        assertEquals("b", list.get(2));
        assertFalse(list.isEmpty());
        list.add(3, "d");
        
    }

    /**
     * Test the output of the addLast behavior
     */
    @Test
    public void testAddLast() {
    	assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.addLast("one");
        assertEquals(1, list.size());
        assertEquals("one", list.get(0));
        assertFalse(list.isEmpty());
        
        list.addLast("two");
        assertEquals(2, list.size());
        assertEquals("two", list.get(1));
        assertFalse(list.isEmpty());
        
        list.addLast("three");
        assertEquals(3, list.size());
        assertEquals("three", list.get(2));
        assertFalse(list.isEmpty());
    }

    /**
     * Test the output of the last() behavior, including expected exceptions
     */
    @Test
    public void testLast() {
    	assertThrows(IndexOutOfBoundsException.class, () -> list.last());
		list.add(0, "a");
		assertEquals("a", list.last());
		list.add(1, "b");
		assertEquals("b", list.last());
		list.addLast("c");
		assertEquals("c", list.last());
	}    

    /**
     * Test the output of the addFirst behavior
     */
    @Test
    public void testAddFirst() {
        list.addFirst("a");
        assertEquals(1, list.size());
        assertEquals("a", list.get(0));
        list.add(1, "b");
        list.add(2, "c");
        list.addFirst("d");
        assertEquals(4, list.size());
        assertEquals("d", list.get(0));
        assertEquals("a", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals("c", list.get(3));
    }

    /**
     * Test the output of the first() behavior, including expected exceptions
     */
    @Test
    public void testFirst() {
    	assertThrows(IndexOutOfBoundsException.class, () -> list.first());
    	list.addFirst("a");
    	assertEquals("a", list.first());
    	list.addFirst("b");
    	assertEquals("b", list.first());
    }

    /**
     * Test the iterator behaviors, including expected exceptions
     */
    @Test
    public void testIterator() {
        // Start with an empty list
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        
        // Create an iterator for the empty list
        Iterator<String> it = list.iterator();
        
        // Try different operations to make sure they work
        // as expected for an empty list (at this point)
        try{
            it.remove();
            fail("An IllegalStateException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
        assertFalse(it.hasNext());

        // Now add an element
        list.addLast("one");
        
        // Use accessor methods to check that the list is correct
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals("one", list.get(0));
        
        // Create an iterator for the list that has 1 element
        it = list.iterator();
        
        // Try different iterator operations to make sure they work
        // as expected for a list that contains 1 element (at this point)
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertFalse(it.hasNext());
        try{
            it.next();
            fail("A NoSuchElementException should have been thrown");           
        } catch(Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }

        list.addLast("two");
        list.addLast("three");
        it = list.iterator();
        assertEquals("one", it.next());
        assertEquals("two", it.next());
        
        it.remove();
        assertTrue(it.hasNext());
        assertEquals(list.size(), 2);
        assertEquals("three", it.next());
        it.remove();
        assertEquals(list.size(), 1);
        
    }

    /**
     * Test the output of the remove(index) behavior, including expected exceptions
     */
    @Test
    public void testRemoveIndex() {
    	assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    	list.addLast("a");
    	list.addLast("b");
    	list.addLast("c");
    	assertEquals(3, list.size());
    	assertEquals("b", list.remove(1));
    	assertEquals(2, list.size());
    	assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));
    }

    /**
     * Test the output of the removeFirst() behavior, including expected exceptions
     */
    @Test
    public void testRemoveFirst() {
    	assertThrows(IndexOutOfBoundsException.class, () -> list.removeFirst());
    	list.addLast("a");
    	list.addLast("b");
    	list.addLast("c");
    	assertEquals(3, list.size());
    	assertEquals("a", list.removeFirst());
    	assertEquals(2, list.size());
    }

    /**
     * Test the output of the removeLast() behavior, including expected exceptions
     */
    @Test
    public void testRemoveLast() {
    	assertThrows(IndexOutOfBoundsException.class, () -> list.removeLast());
    	list.addLast("a");
    	list.addLast("b");
    	list.addLast("c");
    	assertEquals(3, list.size());
    	assertEquals("c", list.removeLast());
    	assertEquals(2, list.size());
    }

    /**
     * Test the output of the set(index, e) behavior, including expected exceptions
     */
    @Test
    public void testSet() {
    	assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, "a"));
    	list.addLast("a");
    	list.addLast("b");
    	list.addLast("c");
    	assertEquals(3, list.size());
    	assertEquals("b", list.set(1, "2"));
    	assertEquals(3, list.size());
    	assertEquals("a", list.get(0));
    	assertEquals("2", list.get(1));
    	assertEquals("c", list.get(2));
    }
}
