package com.ideas2it.collegeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.collegeManagement.model.College;

public interface CollegeDao extends JpaRepository<College, Integer>{

}
