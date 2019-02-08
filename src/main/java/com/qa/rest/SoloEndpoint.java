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

@Path("/solo")
public class SoloEndpoint {

	@Inject
	private SoloService service;

	public void setService(SoloService service) {
		this.service = service;
	}

	@Path("{path}/json")
	@POST
	@Produces({ "application/json" })
	public String createEntry(String input, @PathParam("path") String path) {
		return service.createEntry(input, path);
	}

	@Path("{path}/json")
	@GET
	@Produces({ "application/json" })
	public String readEntries(@PathParam("path") String path) {
		return service.readEntries(path);
	}

	@Path("{path}/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateEntry(@PathParam("id") Long id, String input, @PathParam("path") String path) {
		return service.updateEntry(id, input, path);
	}

	@Path("{path}/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteEntry(@PathParam("id") Long id, @PathParam("path") String path) {
		return service.deleteEntry(id, path);
	}
}
