package com.qa.MapTests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;

public class AccountServiceTest {

	Account Account;
	Account Account2;

	Map<Long, Account> accountMap;

	@Before
	public void setup() {
		accountMap = new HashMap<>();
		Account = new Account("Billy", "Bob", "1");
		Account = new Account("Big", "Pete", "2");
		
	}

	@Test
	public void addAccountTest() {

		accountMap.put((long) 111111, Account);

		accountMap.size();

	}

	@Test
	public void add2AccountTest() {

		accountMap.put((long) 222222, Account2);

		accountMap.size();
		
	}

	@Test
	public void removeAccountTest() {

		accountMap.remove(Account2);
		accountMap.containsKey(Account2);

	}

	@Test
	public void remove2AccountTest() {
		accountMap.remove(Account);
		accountMap.containsKey(Account);
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {

	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {

	}

	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {

	}

	@Test
	public void accountConversionToJSONTest() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {

	}

}
