package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator to compare students based on id number
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class StudentIDComparator implements Comparator<Student> {

	/**
	 * Compares students based on id number in ascending order
	 * 
	 * @param one is first student
	 * @param two is second student
	 * @return -1 if first parameter goes before second, 1 if first parameter goes
	 *         after second, 0 if both are equal
	 */
	@Override
	public int compare(Student one, Student two) {
		if (one.getId() < two.getId()) {
			return -1;
		} else if (one.getId() > two.getId()) {
			return 1;
		} else {
			return 0;
		}
	}

}
