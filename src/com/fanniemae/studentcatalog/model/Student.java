package com.fanniemae.studentcatalog.model;

/**
 * This entity defines the attributes and behaviors of a Student Object.
 * 
 * @author Andres Pena
 *
 */
public class Student extends User {

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String ssn, String username, String password) {
		super(firstName, lastName, ssn, username, password, Role.STUDENT.code());
	}

}
