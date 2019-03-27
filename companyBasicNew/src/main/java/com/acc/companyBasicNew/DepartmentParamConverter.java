package com.acc.companyBasicNew;

import javax.ws.rs.ext.ParamConverter;

public class DepartmentParamConverter implements ParamConverter<Department>{


	@Override
	public Department fromString(String input) {
		Department d = new Department(100,"hps",0,"yogesh");
		
		if(input.equalsIgnoreCase("hps")) {
			return d;
		}else if(input.equalsIgnoreCase("core")) {
			return new Department(101,"core",0,"Rahul");
		}
		return d;
	}
	
	@Override
	public String toString(Department d) {
		// TODO Auto-generated method stub
		return d.toString();
	}
	

}
