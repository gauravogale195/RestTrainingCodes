package com.acc.companyBasicNew;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("department")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {
	CompanyService service = new CompanyService();

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response getAllDept() {
	 * GenericEntity<List<Department>> data = new
	 * GenericEntity<List<Department>>(service.getAllDept()) {}; Response res
	 * =Response.status(Status.OK).entity(data).build(); return res;
	 * 
	 * }
	 */
	/*
	 * @GET
	 * 
	 * @Path("/{dname}") public Response getDept(@PathParam("dname") String dname) {
	 * Department dept = service.getDept(dname); Response response = null; if(dept
	 * ==null) { throw new DataNotFoundException("DeptName = "+dname +
	 * " ,No Such Department"); } response = Response.ok(dept).build();
	 * 
	 * return response; }
	 */	
	/*
	 * @GET
	 * 
	 * @Path("/{dname}") public Department getDept(@PathParam("dname") String dname)
	 * {
	 * 
	 * 
	 * 
	 * return service.getDept(dname); }
	 */

	//@GET for HATEOS
	@GET
	@Path("/{dname}")
	public Response getDept(@PathParam("dname") String dname, @Context UriInfo uriInfo) {
		Department dept=service.getDept(dname);		
		if(dept==null) {
			throw new DataNotFoundException("DeptName - "+ dname+" ,No Such Department");
		}

		//adding links for hateos
		dept.addLink(getUriForSelf(uriInfo, dept), "self");
		dept.addLink(getUriForEmployees(uriInfo, dept), "employees");
		dept.addLink(getUriForDirector(uriInfo, dept), "director");

		Response response =  Response.ok(dept)
				.build();
		return response;
	}


	@GET
	public List<Department> getDept(@DefaultValue("0") @QueryParam("start") int start,
			@QueryParam("size") int size,
			@QueryParam("mincount") int empcount) {
		if(start<=0 && size<=0) {
			return service.getAllDept();
		}else {
			return service.getAllDeptPaginated(start, size, empcount);
		}
	}
	@GET
	@Path("filter")
	public List<Department> getDeptFiltered(@BeanParam DepartmentFilterBean filter) {
		if(filter.getStart()<=0 && filter.getSize()<=0) {
			return service.getAllDept();
		}else {
			return service.getAllDeptPaginated(filter.getStart(),filter.getSize(),filter.getEmpcount());
		}
	}


	/*
	 * @POST public Response addDept(Department d ,@Context UriInfo uriInfo) throws
	 * URISyntaxException {
	 * 
	 * Department dept =service.addDept(d); String dName=d.getDeptName(); URI uri
	 * =uriInfo.getAbsolutePathBuilder().path(dName).build(); Response response=
	 * Response.created(uri).entity(dept).build(); return response;
	 * 
	 * }
	 */


	@POST 
	public Response addDept(Department d) {

		Department dept =service.addDept(d);
		System.out.println("hello");
		//String dName=d.getDeptName();
		Response response= Response.status(Status.CREATED).entity(dept).build();
		return response;

	}


	@PUT
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Department updateDept(Department d) {
		return service.updateDept(d);

	}
	@DELETE
	@Path("/{dname}")
	public Department deleteDept(@PathParam("dname") String id) {
		return service.deleteDept(id);

	}

	@Path("/{dname}/employees")
	public EmployeeResource getEmpResource() {
		return new EmployeeResource();
	}

	/*
	 * @Path("/{dname}/employees") public EmployeeResource getEmpResource() { return
	 * new EmployeeResource(); }
	 */
	
	//HateOS

	private String getUriForSelf(UriInfo uriInfo, Department dept) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(DepartmentResource.class)
				.path(dept.getDeptName())
				.build()
				.toString();
		return uri;
	}

	private String getUriForEmployees(UriInfo uriInfo,  Department dept) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(DepartmentResource.class)
				.path(DepartmentResource.class, "getEmpResource") //method name
				.path(EmployeeResource.class)
				.resolveTemplate("dname", dept.getDeptName())
				.build();
		return uri.toString();
	}

	private String getUriForDirector(UriInfo uriInfo, Department dept) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(DirectorResource.class)
				.path(dept.getDirectorName())
				.build();
		return uri.toString();
	}


}
