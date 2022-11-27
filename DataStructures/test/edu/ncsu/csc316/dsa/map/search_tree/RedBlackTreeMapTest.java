package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * Test class for RedBlackTreeMap Checks the expected outputs of the Map
 * abstract data type behaviors when using a red-black tree data structure
 *
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class RedBlackTreeMapTest {

	/** BST map used for testing */
	private BinarySearchTreeMap<Integer, String> tree;

	/**
	 * Create a new instance of a red-black tree-based map before each test case
	 * executes
	 */
	@Before
	public void setUp() {
		tree = new RedBlackTreeMap<Integer, String>();
	}

	/**
	 * Test the output of the put(k,v) behavior
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());

		// tree in csc316 lecture on red black tree
		tree.put(12, "twelve");
		tree.put(5, "five");
		tree.put(15, "fifteen");
		tree.put(3, "three");
		tree.put(10, "ten");
		tree.put(13, "thirteen");
		tree.put(17, "seventeen");
		tree.put(4, "four");
		tree.put(7, "seven");
		tree.put(11, "eleven");
		tree.put(14, "fourteen");
		tree.put(6, "six");
		tree.put(8, "eight");

		assertEquals(12, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(15, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(3, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(10, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(13, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		assertEquals(17, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		tree.put(1, "one");
		assertEquals(12, (int) tree.root().getElement().getKey());
		assertEquals(5, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(3, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(1, (int) tree.left(tree.left(tree.left(tree.root()))).getElement().getKey());

		tree.put(9, "nine");
		assertEquals(9, (int) tree.right(tree.left(tree.right(tree.left(tree.root())))).getElement().getKey());

		assertEquals("twelve", tree.root().getElement().getValue());
		assertEquals("twelve", tree.put(12, "newTwelve"));
		assertEquals("newTwelve", tree.root().getElement().getValue());

	}

	/**
	 * Test the output of the get(k) behavior
	 */
	@Test
	public void testGet() {
		assertEquals("BalanceableBinaryTree[\nnull\n]", tree.toString());
		
		
		// tree in csc316 lecture on red black tree
		tree.put(12, "twelve");
		tree.put(5, "five");
		tree.put(15, "fifteen");
		assertEquals("twelve", tree.get(12));
		assertEquals("five", tree.get(5));
		assertEquals("fifteen", tree.get(15));
		Iterable<Entry<Integer, String>> i = tree.entrySet();
		assertEquals("five", i.iterator().next().getValue());
		assertNull(tree.get(10));

	}

	/**
	 * Test the output of the remove(k) behavior
	 */
	@Test
	public void testRemove() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());

		// tree in csc316 lecture on red black tree
		tree.put(12, "twelve");
		tree.put(5, "five");
		tree.put(15, "fifteen");
		tree.put(3, "three");
		tree.put(10, "ten");
		tree.put(13, "thirteen");
		tree.put(17, "seventeen");
		tree.put(4, "four");
		tree.put(7, "seven");
		tree.put(11, "eleven");
		tree.put(14, "fourteen");
		tree.put(6, "six");
		tree.put(8, "eight");
		
		assertEquals("five", tree.remove(5));
		assertEquals(6, (int) tree.left(tree.root()).getElement().getKey());
		
		assertEquals("three", tree.remove(3));
		assertEquals(4, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		
		assertEquals("eleven", tree.remove(11));
		assertEquals(8, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		
		assertEquals("four", tree.remove(4));
		assertEquals(12, (int) tree.root().getElement().getKey());
		assertEquals(8, (int)tree.left(tree.root()).getElement().getKey());
		
		
	}
}