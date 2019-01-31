package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id
	private Long id;
	
	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public Account() {
		
	}
	
	public Account(String fName, String lName, int aNumber) {
		this.firstName = fName;
		this.lastName = lName;
		this.accountNumber = aNumber;
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

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccount() {
		return firstName + " " + lastName + " " + accountNumber;
	}

}
