package com.ideas2it.collegeManagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegeManagement.model.Department;
import com.ideas2it.collegeManagement.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/viewDepartments")
	public List<Department> viewDepartment() {
		return departmentService.getDepartments();
	}
	
	@GetMapping("/viewDepartment/{id}")
	public Department viewDepartment(@PathVariable("id") int id) {
		return departmentService.getDepartment(id);
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable int id) {
		return departmentService.deleteDepartment(id);
	}
	
	@PutMapping("/updateDepartment/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") int id) {
		return departmentService.updateDepartment(department, id);
	}
		
}