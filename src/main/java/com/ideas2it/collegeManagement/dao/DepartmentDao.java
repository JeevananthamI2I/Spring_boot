package com.ideas2it.collegeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.collegeManagement.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{
	
	
}
