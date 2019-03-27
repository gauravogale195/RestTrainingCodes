package com.acc.companyBasicNew;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class DepartmentFilterBean {

	@DefaultValue("0")
	@QueryParam("start")
	int start;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getEmpcount() {
		return empcount;
	}
	public void setEmpcount(int empcount) {
		this.empcount = empcount;
	}
	@QueryParam("size")
	int size;
	@QueryParam("mincount")
	int empcount;
}
