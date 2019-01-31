package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.utils.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class AccountDBImplementation implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private JSONUtil jsonUtil;
	
	@Override
	public String getAllAccounts() {
	    Query query = em.createQuery("Select a from Account a");
	    Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return jsonUtil.getJSONForObject(accounts);
	}


	@Transactional(REQUIRED)
	@Override
	public String createAccount(String account) {
	    Account anAccount = jsonUtil.getObjectForJSON(account, Account.class);
	    em.persist(anAccount);
	    
		return "{ \"Message\" : \"The account has been made\"}";
	}
	

	@Transactional(REQUIRED)
	@Override
	public String deleteAccount(Long id) {
		
		Account thisAccount = em.find(Account.class, id);
		if(thisAccount != null) {
			em.detach(thisAccount);
			return "{ \"Message\" : \"The account has been deleted\"}";
		}
		
		return "{ \"Message\" : \"The account did not exist\"}";
	}
	
	
	@Transactional(REQUIRED)
	@Override
	public String updateAccount(Long id, String account) {
		
		Account newAccountDetails = jsonUtil.getObjectForJSON(account, Account.class);
		Account thisAccount = em.find(Account.class, id);
		if(thisAccount != null) {
			em.remove(thisAccount);
			em.persist(newAccountDetails);
			return "{ \"Message\" : \"The account has been updated\"}";
		}
		
		
		return "{ \"Message\" : \"The account did not exist\"}";
	}
	
	
	public String findAnAccount(Long id) {
		em.find(Account.class, id);
		return "{ \"Message\" : \"Returned the Account\"}";
	}

	
	
}
