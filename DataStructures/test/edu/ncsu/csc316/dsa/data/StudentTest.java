package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test methods in Student class
 * 
 * @author TungTran
 *
 */
public class StudentTest {

	/** Student one */
	private Student sOne;
	/** Student one with different first name */
	private Student sOnev2;
	/** Student one with different id */
	private Student sOnev3;
	/** Student two */
	private Student sTwo;

	/**
	 * Executes before test case runs
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sOnev2 = new Student("OneFirstv2", "OneLast", 1, 1, 1.0, "oneUnityID");
		sOnev3 = new Student("OneFirst", "OneLast", 12, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
	}

	/**
	 * Testing setFirst method
	 */
	@Test
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}

	/**
	 * Testing setLast method
	 */
	@Test
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}

	/**
	 * Testing setId method
	 */
	@Test
	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}

	/**
	 * Testing setGpa method
	 */
	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}

	/**
	 * Testing setUnityId method
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}

	/**
	 * Testing compareTo method
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertSame(sOne.compareTo(sOne), 0);
		assertSame(sTwo.compareTo(sTwo), 0);

		assertTrue(sOne.compareTo(sOnev2) < 0);
		assertTrue(sOnev2.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOnev3) < 0);
		assertTrue(sOnev3.compareTo(sOne) > 0);
	}

	/**
	 * Testing setCreditHours method
	 */
	@Test
	public void testSetCreditHours() {
		sOne.setCreditHours(18);
		assertEquals(18, sOne.getCreditHours());
	}

	/**
	 * Testing equals method
	 */
	@Test
	public void testEquals() {
		assertFalse(sOne.equals(sTwo));
		assertTrue(sOne.equals(sOne));
	}

	/**
	 * Testing toString method
	 */
	@Test
	public void testToString() {
		assertEquals(sOne.toString(),
				"Student [first=OneFirst, last=OneLast, id=1, creditHours=1, gpa=1.0, unityID=oneUnityID]");
	}
}
