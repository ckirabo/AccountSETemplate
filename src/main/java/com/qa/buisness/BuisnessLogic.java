package com.qa.buisness;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.utils.JSONUtil;

public class BuisnessLogic implements AccountServices {

	@Inject
	private AccountRepository accountRepo;
	
	private JSONUtil json;

	@Override
	public String getAllAccounts() {
		return accountRepo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {

		json = new JSONUtil();
		Account anAccount = json.getObjectForJSON(account, Account.class);
		if (anAccount.getAccountNumber() == 9) {
			return "{ \"Message\" : \"This account has been blocked\"}";
		}
		
		return accountRepo.createAccount(account);
		
	}

	@Override
	public String deleteAccount(Long id) {
		
		return accountRepo.deleteAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
	
		return accountRepo.updateAccount(id, account);
	}

}
