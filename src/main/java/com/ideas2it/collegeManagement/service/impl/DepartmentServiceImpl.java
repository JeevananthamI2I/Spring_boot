package com.ideas2it.collegeManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.collegeManagement.dao.DepartmentDao;
import com.ideas2it.collegeManagement.model.Department;
import com.ideas2it.collegeManagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentRepository;

	public Department saveDepartment(Department department) {
		department.setCode(Code());
		return departmentRepository.save(department);
	}

	public String Code() {
		long value = departmentRepository.count();
		return "DEP" + (++value);
	}

	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDepartment(int id) {
		return departmentRepository.findById(id).get();

	}

	public String deleteDepartment(int id) {
		departmentRepository.deleteById(id);
		return "Delete Successfull  " + id;
	}

	public Department updateDepartment(Department department, int id) {
		Department existingDepartment = departmentRepository.findById(id).orElse(null);
		if(null != existingDepartment) {
			existingDepartment.setName(department.getName());
		
		}
		departmentRepository.save(existingDepartment);
		return existingDepartment;
		
	}
	
}
