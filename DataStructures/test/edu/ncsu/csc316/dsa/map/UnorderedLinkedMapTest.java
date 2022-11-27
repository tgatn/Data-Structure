package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;
//import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for UnorderedLinkedMap Checks the expected outputs of the Map
 * abstract data type behaviors when using an unordered link-based list data
 * structure that uses the move-to-front heuristic for self-organizing entries
 * based on access frequency
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class UnorderedLinkedMapTest {

	/** map that holds some key and associated value */
	private Map<Integer, String> map;

	/**
	 * Create a new instance of an unordered link-based map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		map = new UnorderedLinkedMap<Integer, String>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals("UnorderedLinkedMap[3]", map.toString());
		assertEquals(1, map.size());

		assertNull(map.put(2, "string2"));
		assertNull(map.put(1, "string1"));
		assertEquals("UnorderedLinkedMap[1, 2, 3]", map.toString());
		assertEquals(3, map.size());

		assertEquals("string3", map.put(3, "new3"));

		assertEquals("UnorderedLinkedMap[3, 1, 2]", map.toString());
		assertEquals(3, map.size());
		assertNull(map.put(10, "string10"));
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
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());

		assertEquals("string1", map.get(1));
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());

		assertEquals("string5", map.get(5));
		assertEquals("UnorderedLinkedMap[5, 1, 4, 2, 3]", map.toString());
		
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
		assertEquals("UnorderedLinkedMap[1, 4, 2, 5, 3]", map.toString());

		assertEquals("string2", map.remove(2));
		assertEquals("UnorderedLinkedMap[1, 4, 5, 3]", map.toString());
		assertEquals(4, map.size());
		
		assertNull(map.remove(10));
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

		assertEquals("string1", map.values().iterator().next());
		assertTrue(map.values().iterator().hasNext());
		assertThrows(UnsupportedOperationException.class, () -> map.values().iterator().remove());
	}
}