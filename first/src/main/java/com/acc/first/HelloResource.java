package com.acc.first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "hello";
	}
    
    @Path("/{nm}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloName(@PathParam("nm") String name){
    	return "hello" + name;
    }
}
