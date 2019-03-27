package com.acc.companyBasicNew;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.message.internal.ByteArrayProvider;

@Provider
public class DepartmentMessageBodyReader implements MessageBodyReader<Department> {
    
	@Override
    public boolean isReadable(Class<?> type, Type genericType,
                              Annotation[] annotations, MediaType mediaType) {
		if(type.isAssignableFrom(Department.class) )
		{
			return true;
		}
		return false;
    }
    
    @Override
    public Department readFrom(Class<Department> type, Type genericType,
                          Annotation[] annotations, MediaType mediaType,
                          MultivaluedMap<String, String> httpHeaders,
                          InputStream inputStream)
            throws IOException, WebApplicationException
    {
       
        String json = ByteArrayProvider.readFromAsString(inputStream, MediaType.APPLICATION_JSON_TYPE);
        inputStream.close();
		
		Type t = new Department().getClass();
		System.out.println("HelloReader");
		
		//Using Json-B API to read incoming JSON msg
		Jsonb jsonb = JsonbBuilder.create();

		Department d = jsonb.fromJson(json,Department.class);
		
		//Reducing department count
		if(d.getCount()>1) {
			d.setCount(d.getCount()-1);
		}
		return d;
    }
}