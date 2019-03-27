package com.acc.companyBasicNew;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class CompanyService {

	private static Map<String, Department> depts = CompanyDao.getDepartments();
	private static Map<String, Director> dirctrs = CompanyDao.getDirectors();
	
	static {
		depts.put("IT", new Department(1, "IT", 120,"Anil"));
		depts.put("HR", new Department(2, "HR", 3,"Anil"));
		depts.put("Ops", new Department(3, "Ops", 40,"Vijay"));
		depts.put("Finance", new Department(4, "Finance", 70,"Anil"));
		depts.put("Digital", new Department(5, "Digital", 70,"Vijay"));
		
		dirctrs.put("Vijay", new Director(1,"Vijay",5));
		dirctrs.put("Anil", new Director(2,"Anil",3));
		dirctrs.put("Rajiv", new Director(3,"Rajiv",1));
		
	}	
	

	public List<Director> getAllDirector() {
		return new ArrayList<>(dirctrs.values()) ;
	}

	public Director getDirector(String dname) {
		return dirctrs.get(dname);
	}

	public Director addDirector(Director d) {
		d.setDirectorId(dirctrs.size() + 1);
		dirctrs.put(d.getDirectorName(), d);
		return d ;
	}
	
	public Director deleteDirector(String dname) {
		return dirctrs.remove(dname);
	}

	public Director updateDirector(Director d) {
		if(d.getDirectorName()==null || d.getDirectorName().isEmpty())
			return null;
		dirctrs.put(d.getDirectorName(), d);
		return d ;
	}
	
	//-------------Dept related methods-----------------------
	
	public List<Department> getAllDept() {
		return new ArrayList<>(depts.values());
	}
	
	public List<Department> getAllDeptPaginated(int start, int size, int empcount) {
		
		List<Department> filterList= new ArrayList<>();		
		List<Department> allList= new ArrayList<>(depts.values());
		if(empcount==0) {
			int end=(size+start)>allList.size()?allList.size():(size+start-1);
			filterList.addAll(allList.subList(start, end));
			return filterList;
		}else {
			for(Department d:allList) {
				if(d.getCount()>empcount) {
					filterList.add(d);
				}
			}
			int end=(size+start)>filterList.size()?filterList.size():(size+start);
			
			return filterList.subList(start, end);
		}
		
		
	}

	public Department getDept(String dName) {
		return depts.get(dName);
	}

	public Department addDept(Department d) {
		d.setDeptId(depts.size() + 1);
		depts.put(d.getDeptName(), d);
		return d ;
	}
	
	public Department updateDept(Department d) {
		if(d.getDeptName()==null || d.getDeptName().isEmpty())
			return null;
		depts.put(d.getDeptName(), d);
		return d ;
	}
	
	public Department deleteDept(String dname) {
		return depts.remove(dname);
	}

	


}
