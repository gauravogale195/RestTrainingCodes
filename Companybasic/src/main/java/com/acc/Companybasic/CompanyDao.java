package com.acc.Companybasic;

import java.util.Map;
import java.util.TreeMap;



public class CompanyDao {
	
	private static Map<String, Director> dirctMap= new TreeMap<>();


	public static Map<String, Director> getDirectors() {
		return dirctMap;
	}
	
	

}
