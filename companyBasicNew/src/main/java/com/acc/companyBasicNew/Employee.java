package com.acc.companyBasicNew;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private int eid;
	private String ename;
	private String dept;
	private int yearOfJoin;
	
	public Employee() {
		
	}
	
	public Employee(int eid, String dept) {
		super();
		this.eid = eid;
		this.dept = dept;
	}
	
	public Employee(int eid, String ename, String dept, int yearOfJoin) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dept = dept;
		this.yearOfJoin = yearOfJoin;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + eid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (eid != other.eid)
			return false;
		return true;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getYearOfJoin() {
		return yearOfJoin;
	}
	public void setYearOfJoin(int yearOfJoin) {
		this.yearOfJoin = yearOfJoin;
	}
}
