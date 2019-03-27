package com.acc.companyBasicNew;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("directors")
public class DirectorResource {
	
	CompanyService service = new CompanyService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Director> getDirectors() {
		return service.getAllDirector();
		
	}
	@GET
	@Path("/{dname : [a-z A-Z]+}")
	@Produces(MediaType.APPLICATION_XML)
	public Director getDirector(@PathParam("dname") String id) {
		return service.getDirector(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Director addDirector(Director d) {
		return service.addDirector(d);
		
	}
	@PUT
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Director updateDirector(Director d) {
		return service.updateDirector(d);
		
	}
	@DELETE
	@Path("/{dname}")
	public Director deleteDirector(@PathParam("dname") String id) {
		return service.deleteDirector(id);
		
	}

}
