package com.ideas2it.collegeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.collegeManagement.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

}
