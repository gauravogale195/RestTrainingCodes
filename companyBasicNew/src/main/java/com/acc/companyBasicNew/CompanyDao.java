package com.acc.companyBasicNew;

import java.util.Map;
import java.util.TreeMap;



public class CompanyDao {
	
	private static Map<String, Department> dMap= new TreeMap<>();
	private static Map<String, Director> dirctMap= new TreeMap<>();
	
	public  static Map<String, Department>  getDepartments(){
		return dMap;
	}

	public static Map<String, Director> getDirectors() {
		return dirctMap;
	}

	
	

}
