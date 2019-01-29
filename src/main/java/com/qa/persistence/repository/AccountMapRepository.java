package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.utils.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	

	
	Map<Long, Account> account = new HashMap<>();

	public String getAllAccounts() {
      
		
		
		return null;
	}

	public String createAccount(String account1) {
		JSONUtil jsonUtil = new JSONUtil();
		
		Account acc = jsonUtil.getObjectForJSON(account1, Account.class);
		
		return acc.getAccount();
	}

	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateAccount(Long id, String account) {
		// TODO Auto-generated method stub
		return null;
	}

}
