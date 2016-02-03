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

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
