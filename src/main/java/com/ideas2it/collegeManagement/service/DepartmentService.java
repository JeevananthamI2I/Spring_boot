package com.ideas2it.collegeManagement.service;

import java.util.List;

import com.ideas2it.collegeManagement.model.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	
	public String Code();

	public List<Department> getDepartments();
	
	public Department getDepartment(int id);
	
	public String deleteDepartment(int id);

	public Department updateDepartment(Department department, int id);

}