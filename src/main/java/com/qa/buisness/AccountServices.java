package com.qa.buisness;

public interface AccountServices {
	
	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(Long id);
	String updateAccount(Long id, String account);

}
