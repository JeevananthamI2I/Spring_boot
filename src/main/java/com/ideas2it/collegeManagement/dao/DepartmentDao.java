package com.ideas2it.collegeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideas2it.collegeManagement.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{
	
	@Query(value = "select count(id) from department", nativeQuery = true)
    Long getDepartmentCount();
}
