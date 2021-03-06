package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.utils.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> accounts = new HashMap<Long, Account>();
	JSONUtil jsonUtil;

	public String getAllAccounts() {

		String tempString = "";

		for (Account T : accounts.values()) {
			String accountToString = T.toString();
			accountToString += " ";
			tempString += accountToString;
		}
		return tempString;

	}

	public String createAccount(String account1) {
		jsonUtil = new JSONUtil();

		Account acc = jsonUtil.getObjectForJSON(account1, Account.class);

		accounts.put((long) acc.getAccountNumber(), acc);

		return "Success";
	}

	public String deleteAccount(Long id) {
		if (accounts.containsKey(id)) {
			accounts.remove(id);
			return "Removed";
		}
		return "Does not exist";
	}

	public String updateAccount(Long id, String account) {

		jsonUtil = new JSONUtil();

		Account acc = jsonUtil.getObjectForJSON(account, Account.class);
		if (accounts.containsKey(id)) {

			acc.setFirstName("Clare");
			acc.setLastName("Kirabo");

			return "Updated";
		}
		return "does not exist";

	}

	public int returnNames(String firstname) {

		String tempString =" ";

		int count = 0;
		for (Account i : accounts.values()) {
			if (i.getFirstName().equals(firstname)) {
				count++;
				String accountToString = i.toString();
				accountToString += " ";
				tempString += accountToString;	
			}
		}

		return count;
	}

}
