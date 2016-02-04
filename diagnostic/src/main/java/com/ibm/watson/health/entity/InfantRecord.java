package com.ibm.watson.health.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class InfantRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5090526238868798208L;
	
	@Id
	private String id;

    private String firstName;
    private String lastName;

    public InfantRecord() {}

    public InfantRecord(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
