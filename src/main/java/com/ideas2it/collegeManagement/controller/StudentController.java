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

import com.ideas2it.collegeManagement.converter.StudentConverter;
import com.ideas2it.collegeManagement.dto.StudentDto;
import com.ideas2it.collegeManagement.model.Student;
import com.ideas2it.collegeManagement.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	StudentConverter studentConverter;
	
	@PostMapping("/addStudent")
	public StudentDto addStudent(@RequestBody Student Student) {
		return studentConverter.entityToDto(studentService.saveStudent(Student));
	}

	@GetMapping("/viewStudents")
	public List<StudentDto> viewStudent() {
		return studentConverter.entityToDto(studentService.getStudents());
	}

	@GetMapping("/viewStudent/{id}")
	public StudentDto viewStudent(@PathVariable("id") int id) {
		return studentConverter.entityToDto(studentService.getStudent(id));
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

	@PutMapping("/updateStudent/{id}")
	public StudentDto updateStudent(@RequestBody Student Student, @PathVariable("id") int id) {
		return studentConverter.entityToDto(studentService.updateStudent(Student, id));
	}
}
