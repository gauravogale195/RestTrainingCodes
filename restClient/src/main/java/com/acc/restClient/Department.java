package com.acc.restClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement 
public class Department {
	private long deptId;
	private String deptName;
	private int count;
	private String directorName;
	//@XmlTransient
	//Map<Integer,Employee> employees = new HashMap<>();
	//private List<Link> links = new ArrayList<>();
	
	/*
	 * public List<Link> getLinks() { return links; }
	 * 
	 * public void setLinks(List<Link> links) { this.links = links; }
	 * 
	 * public Map<Integer, Employee> getEmployees() { return employees; }
	 * 
	 * public void setEmployees(Map<Integer, Employee> employees) { this.employees =
	 * employees; }
	 */

	public Department() {
	}

	public Department(long deptId, String deptName, int count,String directorName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.count = count;
		this.directorName= directorName;
		
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	/*
	 * public void addLink(String url, String rel) { Link link = new Link();
	 * link.setLink(url); link.setRel(rel); links.add(link); }
	 */

	
	

}
