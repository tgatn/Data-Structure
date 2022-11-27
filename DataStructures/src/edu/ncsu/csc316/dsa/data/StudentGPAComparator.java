package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class StudentGPAComparator implements Comparator<Student> {

	/**
	 * Compares students based on GPA in descending order
	 * 
	 * @param one is first student
	 * @param two is second student
	 * @return -1 if first parameter goes before second, 1 if first parameter goes
	 *         after second, 0 if both are equal
	 * 
	 */
	@Override
	public int compare(Student one, Student two) {
		if (one.getGpa() > two.getGpa()) {
			return -1;
		} else if (one.getGpa() < two.getGpa()) {
			return 1;
		} else {
			return one.compareTo(two);
		}
	}

}
