package com.qa.MapTests;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.utils.JSONUtil;

public class AccountServiceTest {

	AccountMapRepository repoClass;
	JSONUtil util;
	String jsonString;
	String jsonString1;



	@Before
	public void setup() {
		
	 	util = new JSONUtil();
	 	repoClass = new AccountMapRepository();
	 	jsonString = "{\"firstName\":\"John\",\"lastName\":\"Beano\",\"accountNumber\":\"1234\"}";
	 	jsonString1 = "{\"firstName\":\"Lee\",\"lastName\":\"Dandy\",\"accountNumber\":\"5432\"}";
	}

	@Test
	public void addAccountTest() {
		
		assertEquals("Did not Work",  "Success",repoClass.createAccount(jsonString));

	}

	@Test
	public void add2AccountTest() {
		repoClass.createAccount(jsonString);
		repoClass.createAccount(jsonString1);
		assertEquals("Did not Work",  "Success",repoClass.createAccount(jsonString));
		assertEquals("Did not Work",  "Success",repoClass.createAccount(jsonString1));
		
	}

	@Test
	public void removeAccountTest() {
		
		assertEquals("Did not Work",  "Success",repoClass.createAccount(jsonString));
		assertEquals("Did not exsist", "Removed", repoClass.deleteAccount(1234L));
	

	}

	@Test
	public void remove2AccountTest() {
		
		repoClass.createAccount(jsonString);
	
		repoClass.createAccount(jsonString1);
		
		assertEquals("Did not exsist", "Removed", repoClass.deleteAccount(5432L));
		assertEquals("Did not exsist", "Removed", repoClass.deleteAccount(1234L));
	
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		
			
		repoClass.createAccount(jsonString);
		repoClass.createAccount(jsonString1);
		assertEquals("Did not Work", "Removed" ,repoClass.deleteAccount(5432L));
		assertEquals("Did not Work", "Does not exist" ,repoClass.deleteAccount(1235L));

	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
		String jsonString = "{\"firstName\":\"Lee\",\"lastName\":\"Dandy\",\"accountNumber\":\"5432\"}";
		Account test = util.getObjectForJSON(jsonString, Account.class);

		
		assertEquals("Not Worked","Lee Dandy 5432",test.getAccount());
		
		}

	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {


		Account anAccount = new Account("Bert", "Smith", 1234);
		
		String account = util.getJSONForObject(anAccount);
		
		repoClass.createAccount(account);
	}

	@Test
	public void accountConversionToJSONTest() {
		
		Account anAccount = new Account("Bert", "Smith", 1234);
		String account = util.getJSONForObject(anAccount);

		
		assertEquals("Worked","{\"firstName\":\"Bert\",\"lastName\":\"Smith\",\"accountNumber\":1234}", account.toString());

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
		String jsonString = "{\"firstName\":\"John\",\"lastName\":\"Beano\",\"accountNumber\":\"1234\"}";
		repoClass.createAccount(jsonString);
	
		
		assertEquals("Did not Work",  "Updated" ,repoClass.updateAccount(1234L, jsonString));

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {

	}

}
