package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test MergeSorter class
 * 
 * @author TungTran
 *
 */
public class MergeSorterTest {

	/** Student one */
	private Student sOne;
	/** Student two */
	private Student sTwo;
	/** Student three */
	private Student sThree;
	/** Student four */
	private Student sFour;
	/** Student five */
	private Student sFive;

	/** instance of MergeSorter */
	private MergeSorter<Student> sorter;

	/**
	 * Executes before test case runs
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "1OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "2TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "3ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "4FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "5FiveLast", 5, 5, 5.0, "fiveUnityID");

		sorter = new MergeSorter<Student>();
	}

	/**
	 * Sorts student given random array
	 */
	@Test
	public void testSortStudentRandom() {
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

	/**
	 * Sorts student given array sorted in descending order
	 */
	@Test
	public void testSortStudentDescending() {
		Student[] original = { sFive, sFour, sThree, sTwo, sOne };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

	/**
	 * Sorts student given array sorted in ascending order
	 */
	@Test
	public void testSortStudentAscending() {
		Student[] original = { sOne, sTwo, sThree, sFour, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}

}
