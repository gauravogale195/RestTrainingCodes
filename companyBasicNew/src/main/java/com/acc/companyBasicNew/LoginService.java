package com.acc.companyBasicNew;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("login")
public class LoginService {
	@Path("employee")
	@POST
	public Response validate(@FormParam("username") String username,
			                 @FormParam("password") String password) {
		if(username.equals("admin") && password.equals("admin")){
			return Response.status(Response.Status.OK).entity("welcome!!").build();
		}
		else {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
	}

}
