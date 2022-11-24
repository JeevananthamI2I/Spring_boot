package com.ideas2it.collegeManagement.service;

import java.util.List;

import com.ideas2it.collegeManagement.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public String Code();

	public List<Student> getStudents();
	
	public Student getStudent(int id);
	
	public String deleteStudent(int id);

	public Student updateStudent(Student student, int id);

}