package com.acc.companyBasicNew;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	EmployeeService service = new EmployeeService();
	
	@GET
	@Path("/{empid}")
	public Response getEmpId(@PathParam("empid") int empid,
			                 @PathParam("dname") String dname) {
		Employee emp = service.getEmployee(dname, empid);
		Response response=null;
		if(emp!=null) {
			response = Response.ok(emp).build();
		}
		else {
			ErrorMessage err = new ErrorMessage("Invalid Employee", "404", "check Logs");
			response = Response.status(Status.NOT_FOUND).entity(err).build();
			
			throw new NotFoundException(response);
		}
		return response;
	}
	
	@POST
	
	public Response addEmployee(Employee emp ,@PathParam("dname") String dname) {
				
		Employee employee = service.addEmployee(dname, emp);
		Response response= Response.status(Status.CREATED).entity(employee).build();
		return response;
	}
	

}
