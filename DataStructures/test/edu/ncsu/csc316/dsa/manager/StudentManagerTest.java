package edu.ncsu.csc316.dsa.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.sorter.CountingSorter;

/**
 * Test StudentManager class
 * @author TungTran
 *
 */
public class StudentManagerTest {

	/** instance of StudentManager */
	private StudentManager sm;

	/**
	 * Executes before test case runs
	 */
	@Before
	public void setUp() {
		sm = new StudentManager("input/student_ascendingID.csv");
	}

	/**
	 * Test sort method
	 */
	@Test
	public void testSort() {
		Student[] sorted = sm.sort();
		assertEquals("Tanner", sorted[0].getFirst());
		assertEquals("Roxann", sorted[1].getFirst());
		assertEquals("Shanti", sorted[2].getFirst());
		assertEquals("Dante", sorted[3].getFirst());
		assertEquals("Cristine", sorted[4].getFirst());
		assertEquals("Ara", sorted[5].getFirst());
		assertEquals("Lewis", sorted[6].getFirst());
		assertEquals("Charlene", sorted[7].getFirst());
		assertEquals("Amber", sorted[8].getFirst());
		assertEquals("Lacie", sorted[9].getFirst());
		assertEquals("Idalia", sorted[10].getFirst());
		assertEquals("Tyree", sorted[11].getFirst());
		assertEquals("Evelin", sorted[12].getFirst());
		assertEquals("Alicia", sorted[13].getFirst());
		assertEquals("Loise", sorted[14].getFirst());
		assertEquals("Nichole", sorted[15].getFirst());
		
		CountingSorter<Student> cs = new CountingSorter<Student>();
		sm = new StudentManager("input/student_ascendingID.csv", cs);
		
		Student[] s = sm.sort();
		assertEquals("Amber", s[0].getFirst());
		assertEquals("Ara", s[1].getFirst());
		assertEquals("Lacie", s[2].getFirst());
		assertEquals("Idalia", s[3].getFirst());
		assertEquals("Evelin", s[4].getFirst());
		assertEquals("Lewis", s[5].getFirst());
		assertEquals("Alicia", s[6].getFirst());
		assertEquals("Tyree", s[7].getFirst());
		assertEquals("Loise", s[8].getFirst());
		assertEquals("Roxann", s[9].getFirst());
		assertEquals("Nichole", s[10].getFirst());
		assertEquals("Charlene", s[11].getFirst());
		assertEquals("Shanti", s[12].getFirst());
		assertEquals("Cristine", s[13].getFirst());
		assertEquals("Tanner", s[14].getFirst());
		assertEquals("Dante", s[15].getFirst());
		
	}


}
