package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.io.StudentReader;

/**
 * Test for InsertionSorter class
 * 
 * @author TungTran
 *
 */
public class InsertionSorterTest {

	/** Array of Integer sorted in ascending order */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };

	/** Array of Integer sorted in descending order */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };

	/** Array of Integer sorted in random order */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };

	/** Instance of InsertionSorter */
	private InsertionSorter<Integer> integerSorter;

	/**
	 * Executes before test case runs
	 */
	@Before
	public void setUp() {
		integerSorter = new InsertionSorter<Integer>();
	}

	/**
	 * Test sort method
	 */
	@Test
	public void testSortIntegers() {
		integerSorter.sort(dataAscending);
		assertEquals("1", dataAscending[0].toString());
		assertEquals("2", dataAscending[1].toString());
		assertEquals("3", dataAscending[2].toString());
		assertEquals("4", dataAscending[3].toString());
		assertEquals("5", dataAscending[4].toString());

		integerSorter.sort(dataDescending);
		assertEquals("1", dataDescending[0].toString());
		assertEquals("2", dataDescending[1].toString());
		assertEquals("3", dataDescending[2].toString());
		assertEquals("4", dataDescending[3].toString());
		assertEquals("5", dataDescending[4].toString());

		integerSorter.sort(dataRandom);
		assertEquals("1", dataRandom[0].toString());
		assertEquals("2", dataRandom[1].toString());
		assertEquals("3", dataRandom[2].toString());
		assertEquals("4", dataRandom[3].toString());
		assertEquals("5", dataRandom[4].toString());
	}

	/**
	 * Test sort method on Student
	 */
	@Test
	public void testSortStudent() {
		Student[] contents = StudentReader.readInputAsArray("input/student_ascendingID.csv");
		InsertionSorter<Student> studentSorter = new InsertionSorter<Student>();
		studentSorter.sort(contents);
		assertEquals("Bauman", contents[0].getLast());
		assertEquals("Carrion", contents[1].getLast());
		assertEquals("Dick", contents[2].getLast());
		assertEquals("Falcon", contents[3].getLast());
		assertEquals("Greco", contents[4].getLast());
		assertEquals("Marsh", contents[5].getLast());
		assertEquals("Matheson", contents[6].getLast());
		assertEquals("Mclendon", contents[7].getLast());
		assertEquals("Michael", contents[8].getLast());
		assertEquals("Mott", contents[9].getLast());
		assertEquals("Pease", contents[10].getLast());
		assertEquals("Runyon", contents[11].getLast());
		assertEquals("Seibert", contents[12].getLast());
		assertEquals("Terrell", contents[13].getLast());
		assertEquals("Woodbury", contents[14].getLast());
		assertEquals("Worth", contents[15].getLast());
		
	}
}
