package com.fanniemae.studentcatalog.model;

public class Student extends User {

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String ssn, String username, String password, String role) {
		super(firstName, lastName, ssn, username, password, role);
	}

}
