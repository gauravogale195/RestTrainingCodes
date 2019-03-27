package com.acc.Companybasic;

import javax.xml.bind.annotation.XmlRootElement;

//Model class
@XmlRootElement //needed by JAXB for xml response
public class Director {
	private int directorId;
	private String directorName;
	private int noOfDepartments;
	
	public Director() {
		
	}
	
	public Director(int directorId, String directorName, int noOfDepartments) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.noOfDepartments = noOfDepartments;
	}



	public int getDirectorId() {
		return directorId;
	}



	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}



	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public int getNoOfDepartments() {
		return noOfDepartments;
	}
	
	public void setNoOfDepartments(int noOfDepartments) {
		this.noOfDepartments = noOfDepartments;
	}
	

}
