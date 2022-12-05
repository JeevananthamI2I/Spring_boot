package com.ideas2it.collegeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideas2it.collegeManagement.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

	@Query(value = "select count(id) from student", nativeQuery = true)
    Long getStudentCount();
}
