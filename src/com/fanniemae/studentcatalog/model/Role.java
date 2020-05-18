package com.fanniemae.studentcatalog.model;

/**
 * Define the posible roles of the users.
 * 
 * @author Andres
 *
 */
public enum Role {

	STUDENT("STD", "Student"), PROFESSOR("PRO", "Professor"), ADMINISTRATOR("ADM", "Administrator");

	private final String code;

	private final String description;

	Role(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String code() {
		return code;
	}

	public String description() {
		return description;
	}

}
