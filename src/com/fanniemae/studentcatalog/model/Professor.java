package com.fanniemae.studentcatalog.model;

/**
 * This entity defines the attributes and behaviors of a Professor Object.
 * 
 * @author Andres Pena
 *
 */
public class Professor extends User {

	public Professor() {
		super();
	}

	public Professor(String firstName, String lastName, String ssn, String username, String password) {
		super(firstName, lastName, ssn, username, password, Role.PROFESSOR.code());
	}

}
