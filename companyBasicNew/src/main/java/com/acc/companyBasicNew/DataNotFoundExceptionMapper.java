package com.acc.companyBasicNew;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{
	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage err= new ErrorMessage(ex.getMessage(), "500", "Check http://www.mycompany.com/excFAQ");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(err).build();
	}

}
