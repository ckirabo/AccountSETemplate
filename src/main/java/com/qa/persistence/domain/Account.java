package com.qa.persistence.domain;

public class Account {
	private String firstName;
	private String lastName;
	private String accountNumber;

	public Account(String fName, String lName, String aNumber) {
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccount() {
		return firstName + lastName + accountNumber;
	}

}
