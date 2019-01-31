package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.buisness.AccountServices;

@Path("/account")
public class AccountEndpoint {

	@Inject 
	private AccountServices buisnessInterface;
	
	@GET
	@Path("/allAccounts")
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return buisnessInterface.getAllAccounts();
	}
	
	
	@POST
	@Path("/createAccount")
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return buisnessInterface.createAccount(account);
	}
	
	@DELETE
	@Path("/deleteAccount/{id}")
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return buisnessInterface.deleteAccount(id);
	}

	@PUT
	@Path("/updateAccount/{id}")
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id, String account) {
		return buisnessInterface.updateAccount(id, account);
	}
	
	
}
