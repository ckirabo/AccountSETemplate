package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.utils.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> accounts = new HashMap<>();

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
		JSONUtil jsonUtil = new JSONUtil();

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

		JSONUtil jsonutil = new JSONUtil();

		Account acc = jsonutil.getObjectForJSON(account, Account.class);
		if (accounts.containsKey(id)) {

			acc.setFirstName("Clare");
			acc.setLastName("Kirabo");
			
			return "Updated";
		}
		return "does not exist";

	}

}
