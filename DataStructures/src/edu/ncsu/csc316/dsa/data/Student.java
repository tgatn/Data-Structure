package edu.ncsu.csc316.dsa.data;

import java.util.Objects;

/**
 * A student is comparable and identifiable. Students have a first name, last
 * name, id number, number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 */
public class Student implements Comparable<Student>, Identifiable {

	/** first name of student */
	private String first;

	/** last name of student */
	private String last;

	/** student's id */
	private int id;

	/** student's credit hours */
	private int creditHours;

	/** student's gpa */
	private double gpa;

	/** student's unityID */
	private String unityID;

	/**
	 * Constructor for Student class
	 * 
	 * @param first       is first name of student
	 * @param last        is last name of student
	 * @param id          is student's id
	 * @param creditHours is student's credit hour
	 * @param gpa         is student's gpa
	 * @param unityID     is student's unityID
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(creditHours);
		setGpa(gpa);
		setUnityID(unityID);
	}

	/**
	 * Returns the first name of student
	 * 
	 * @return first name of student
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the field first to given input
	 * 
	 * @param first is first name of student to be set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Returns the last name of student
	 * 
	 * @return last name of student
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Sets the field last to given input
	 * 
	 * @param last is last name of student to be set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Returns the student's id
	 * 
	 * @return student's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the field id to given input
	 * 
	 * @param id is student's id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the student's credit hours
	 * 
	 * @return student's credit hours
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * Set the field creditHours to given input
	 * 
	 * @param creditHours is student's credit hours
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	/**
	 * Returns the student's gpa
	 * 
	 * @return student's gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * Set the field gpa to given input
	 * 
	 * @param gpa is student's gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * Returns the student's unityId
	 * 
	 * @return student's unityId
	 */
	public String getUnityID() {
		return unityID;
	}

	/**
	 * Set the field unityID to given input
	 * 
	 * @param unityID is student's unityID
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}

	/**
	 * Returns a hash code value for a student object
	 * 
	 * @return hash code value for a student object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(creditHours, first, gpa, id, last, unityID);
	}

	/**
	 * Indicates whether some other student object is equivalent to the current
	 * object
	 * 
	 * @param s is student to be compared to
	 * @return true if student's first, last, and id are equal; false otherwise
	 */
	@Override
	public boolean equals(Object s) {
		return first.equals(((Student) s).getFirst()) && last.equals(((Student) s).getLast())
				&& id == ((Student) s).getId();
	}

	/**
	 * Compares two student objects based on last name, first name, then id number
	 * 
	 * @param s is student to be compared to
	 * @return 0 if student is equal, -1 if current student comes before parameter,
	 *         1 if current student comes after parameter
	 */
	public int compareTo(Student s) {
		if (last.compareTo(s.getLast()) == 0) {
			if (first.compareTo(s.getFirst()) == 0) {
				if (id > s.getId()) {
					return 1;
				} else if (id < s.getId()) {
					return -1;
				} else {
					return 0;
				}
			} else if (first.compareTo(s.getFirst()) > 0) {
				return 1;
			} else {
				return -1;
			}
		} else if (last.compareTo(s.getLast()) > 0) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Returns the field of students in a string format
	 * 
	 * @return student's information
	 */
	@Override
	public String toString() {
		return "Student [first=" + first + ", last=" + last + ", id=" + id + ", creditHours=" + creditHours + ", gpa="
				+ gpa + ", unityID=" + unityID + "]";
	}

}
