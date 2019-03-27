package com.acc.companyBasicNew;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * A generic exception Mapper that catches all Exception Subclasses
 * Not generally a good design better to use WebApplicationException
 * Uncomment @Provider annotation to let Jersey detect
 */
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception ex) {
		ErrorMessage err= new ErrorMessage(ex.getMessage(), "500", "Check http://www.mycompany.com/excFAQ");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(err).build();
	}

}
