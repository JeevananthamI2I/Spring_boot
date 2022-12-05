package com.ideas2it.collegeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.collegeManagement.converter.DepartmentConverter;
import com.ideas2it.collegeManagement.dto.DepartmentDto;
import com.ideas2it.collegeManagement.model.Department;
import com.ideas2it.collegeManagement.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DepartmentConverter departmentConverter;
	
	@PostMapping("/addDepartment")
	public DepartmentDto addDepartment(@RequestBody Department department) {
		return departmentConverter.entityToDto(departmentService.saveDepartment(department));
	}
	
	@GetMapping("/viewDepartments")
	public List<DepartmentDto> viewDepartment() {
		return departmentConverter.entityToDto(departmentService.getDepartments());
	}
	
	@GetMapping("/viewDepartment/{id}")
	public DepartmentDto viewDepartment(@PathVariable("id") int id) {
		return departmentConverter.entityToDto(departmentService.getDepartment(id));
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable int id) {
		return departmentService.deleteDepartment(id);
	}
	
	@PutMapping("/updateDepartment/{id}")
	public DepartmentDto updateDepartment(@RequestBody Department department, @PathVariable("id") int id) {
		return departmentConverter.entityToDto(departmentService.updateDepartment(department, id));
	}
		
}