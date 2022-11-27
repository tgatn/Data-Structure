package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
import edu.ncsu.csc316.dsa.sorter.QuickSorter.FirstElementSelector;
import edu.ncsu.csc316.dsa.sorter.QuickSorter.LastElementSelector;
import edu.ncsu.csc316.dsa.sorter.QuickSorter.MiddleElementSelector;

/**
 * Test for QuickSorter class
 * @author TungTran
 *
 */
public class QuickSorterTest {


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

	/** instance of QuickSorter with comparator */
	private QuickSorter<Student> sorter;
	
	/** instance of QuickSorter without comparator*/
	private QuickSorter<Student> sorter2;
	
	/** instance of QuickSorter with FirstElementSelector */
	private QuickSorter<Student> sorterF;
	
	/** instance of QuickSorter with LastElementSelector */
	private QuickSorter<Student> sorterL;
	
	/** instance of QuickSorter with MiddleElementSelector */
	private QuickSorter<Student> sorterM;
	
	/** instance of comparator for student id */
	private StudentIDComparator comparator;
	
	/** instance of FirstElementSelector */
	FirstElementSelector f = new FirstElementSelector();
	
	/** instance of LastElementSelector */
	LastElementSelector l = new LastElementSelector();
	
	/** instance of MiddleElementSelector */
	MiddleElementSelector m = new MiddleElementSelector();
	

	/**
	 * Executes before test case runs
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "1OneLast", 1, 1, 1.0, "1oneUnityID");
		sTwo = new Student("TwoFirst", "2TwoLast", 2, 2, 2.0, "2twoUnityID");
		sThree = new Student("ThreeFirst", "3ThreeLast", 3, 3, 3.0, "3threeUnityID");
		sFour = new Student("FourFirst", "4FourLast", 4, 4, 4.0, "4fourUnityID");
		sFive = new Student("FiveFirst", "5FiveLast", 5, 5, 5.0, "5fiveUnityID");
		
		comparator = new StudentIDComparator();
		sorter = new QuickSorter<Student>(comparator);
		sorter2 = new QuickSorter<Student>();
		
		sorterF = new QuickSorter<Student>(f);
		
		sorterL = new QuickSorter<Student>(null, l);
		
		sorterM = new QuickSorter<Student>(null, m);
		
		
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
		
		Student[] original2 = { sTwo, sOne, sFour, sThree, sFive };
		sorter2.sort(original2);
		assertEquals(sOne, original2[0]);
		assertEquals(sTwo, original2[1]);
		assertEquals(sThree, original2[2]);
		assertEquals(sFour, original2[3]);
		assertEquals(sFive, original2[4]);
		
		Student[] originalF = { sTwo, sOne, sFour, sThree, sFive };
		sorterF.sort(originalF);
		assertEquals(sOne, originalF[0]);
		assertEquals(sTwo, originalF[1]);
		assertEquals(sThree, originalF[2]);
		assertEquals(sFour, originalF[3]);
		assertEquals(sFive, originalF[4]);
		
		Student[] originalL = { sTwo, sOne, sFour, sThree, sFive };
		sorterL.sort(originalL);
		assertEquals(sOne, originalL[0]);
		assertEquals(sTwo, originalL[1]);
		assertEquals(sThree, originalL[2]);
		assertEquals(sFour, originalL[3]);
		assertEquals(sFive, originalL[4]);
		
		Student[] originalM = { sTwo, sOne, sFour, sThree, sFive };
		sorterM.sort(originalM);
		assertEquals(sOne, originalM[0]);
		assertEquals(sTwo, originalM[1]);
		assertEquals(sThree, originalM[2]);
		assertEquals(sFour, originalM[3]);
		assertEquals(sFive, originalM[4]);

		
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
		
		Student[] original2 = { sFive, sFour, sThree, sTwo, sOne };
		sorter2.sort(original2);
		assertEquals(sOne, original2[0]);
		assertEquals(sTwo, original2[1]);
		assertEquals(sThree, original2[2]);
		assertEquals(sFour, original2[3]);
		assertEquals(sFive, original2[4]);
		
		Student[] originalF = { sFive, sFour, sThree, sTwo, sOne };
		sorterF.sort(originalF);
		assertEquals(sOne, originalF[0]);
		assertEquals(sTwo, originalF[1]);
		assertEquals(sThree, originalF[2]);
		assertEquals(sFour, originalF[3]);
		assertEquals(sFive, originalF[4]);
		
		Student[] originalL = { sFive, sFour, sThree, sTwo, sOne };
		sorterL.sort(originalL);
		assertEquals(sOne, originalL[0]);
		assertEquals(sTwo, originalL[1]);
		assertEquals(sThree, originalL[2]);
		assertEquals(sFour, originalL[3]);
		assertEquals(sFive, originalL[4]);
		
		Student[] originalM = { sFive, sFour, sThree, sTwo, sOne };
		sorterM.sort(originalM);
		assertEquals(sOne, originalM[0]);
		assertEquals(sTwo, originalM[1]);
		assertEquals(sThree, originalM[2]);
		assertEquals(sFour, originalM[3]);
		assertEquals(sFive, originalM[4]);
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
		
		Student[] original2 = { sOne, sTwo, sThree, sFour, sFive };
		sorter2.sort(original2);
		assertEquals(sOne, original2[0]);
		assertEquals(sTwo, original2[1]);
		assertEquals(sThree, original2[2]);
		assertEquals(sFour, original2[3]);
		assertEquals(sFive, original2[4]);
		
		Student[] originalF = { sOne, sTwo, sThree, sFour, sFive };
		sorterF.sort(originalF);
		assertEquals(sOne, originalF[0]);
		assertEquals(sTwo, originalF[1]);
		assertEquals(sThree, originalF[2]);
		assertEquals(sFour, originalF[3]);
		assertEquals(sFive, originalF[4]);
		
		Student[] originalL = { sOne, sTwo, sThree, sFour, sFive };
		sorterL.sort(originalL);
		assertEquals(sOne, originalL[0]);
		assertEquals(sTwo, originalL[1]);
		assertEquals(sThree, originalL[2]);
		assertEquals(sFour, originalL[3]);
		assertEquals(sFive, originalL[4]);
		
		Student[] originalM = { sOne, sTwo, sThree, sFour, sFive };
		sorterM.sort(originalM);
		assertEquals(sOne, originalM[0]);
		assertEquals(sTwo, originalM[1]);
		assertEquals(sThree, originalM[2]);
		assertEquals(sFour, originalM[3]);
		assertEquals(sFive, originalM[4]);
	}

}
