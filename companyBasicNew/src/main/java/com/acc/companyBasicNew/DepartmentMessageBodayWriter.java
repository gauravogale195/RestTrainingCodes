package com.acc.companyBasicNew;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
public class DepartmentMessageBodayWriter implements MessageBodyWriter<Department> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		if(type.isAssignableFrom(Department.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Department t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		Jsonb jsonb = JsonbBuilder.create();
		String jsonString = jsonb.toJson(t);
		
		System.out.println(jsonString);
		jsonString = jsonString.replaceAll("directorName", "dirName");
		entityStream.write(jsonString.getBytes());
		
	}
}
