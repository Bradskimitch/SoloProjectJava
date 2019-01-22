package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.SoloService;

@Path("/account")
public class SoloEndpoint {

	@Inject
	private SoloService service;

	public void setService(SoloService service) {
		this.service = service;
	}

	// Accounts

	@Path("account/json")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createAccount(account);
	}

	@Path("account/json")
	@GET
	@Produces({ "application/json" })
	public String readAccounts() {
		return service.readAccounts();
	}

	@Path("account/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		return service.updateAccount(id, account);
	}

	@Path("account/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}

	// Creatures

	@Path("creature/json")
	@POST
	@Produces({ "application/json" })
	public String createCreature(String creature) {
		return service.createCreature(creature);
	}

	@Path("creature/json")
	@GET
	@Produces({ "application/json" })
	public String readCreatures() {
		return service.readCreatures();
	}

	@Path("creature/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updatecreature(@PathParam("id") Long id, String creature) {
		return service.updateCreature(id, creature);
	}

	@Path("creature/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deletecreature(@PathParam("id") Long id) {
		return service.deleteCreature(id);
	}

}
