package com.acc.companyBasicNew;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeService {
	
	private static Map<String, Department> depts = CompanyDao.getDepartments();
	
	public List<Employee> getAllEmployees(String dname) {
		Map<Integer, Employee> empList = depts.get(dname).getEmployees();
		return new ArrayList<Employee>(empList.values());
	}
	
	public Employee getEmployee(String dname, int empid) {
	
		Department message = depts.get(dname);
		if (message == null) {
			return null;
		}
		Map<Integer, Employee> empList = depts.get(dname).getEmployees();
		Employee emp = empList.get(empid);
		if (emp == null) {
			return null;
		}
		return emp;
	}
	
	public Employee addEmployee(String dname, Employee emp) {
		Map<Integer, Employee> empList = depts.get(dname).getEmployees();
		emp.setEid(empList.size() + 1);
		empList.put(emp.getEid(), emp);
		return emp;
	}
	
	public Employee updateEmployee(String dname, Employee emp) {
		Map<Integer, Employee> empList = depts.get(dname).getEmployees();
		if (emp.getEid() <= 0) {
			return null;
		}
		empList.put(emp.getEid(), emp);
		return emp;
	}
	
	public Employee deleteEmployee(String dname, int empid) {
		Map<Integer, Employee> empList = depts.get(dname).getEmployees();
		return empList.remove(empid);
	}
		
}
